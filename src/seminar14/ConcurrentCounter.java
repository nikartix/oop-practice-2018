package seminar14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class ConcurrentCounter {
	
	private int value;
	private Lock valueLock;
	private List<PredicateCondition> conditions;
	
	private class PredicateCondition {
		Predicate<Integer> predicate;
		Condition condition;
		
		public PredicateCondition(Predicate<Integer> predicate, Condition condition) {
			this.predicate = predicate;
			this.condition = condition;
		}
	}
	
	public ConcurrentCounter(int initialValue) {
		this.value = initialValue;
		this.valueLock = new ReentrantLock();
		this.conditions = new ArrayList<>();
	}
	
	public void waitFor(Predicate<Integer> predicate) throws InterruptedException {
		valueLock.lock();

		try {

			if (!predicate.test(value)) {
				Condition condition = valueLock.newCondition();
				conditions.add(new PredicateCondition(predicate, condition));
				condition.await();
			}

		} finally {
			valueLock.unlock();
		}
	}
	
	private void checkAllConditions() {
		List<PredicateCondition> newList = new ArrayList<>();
		
		for (PredicateCondition c : conditions) {
			if (c.predicate.test(value)) {
				c.condition.signalAll();
			} else {
				newList.add(c);
			}
		}
		
		conditions = newList;
	}
	
	public int increment(int by) {
		int res = 0;
		valueLock.lock();

		try {
			value += by;
			res = value;
			checkAllConditions();
		} finally {
			valueLock.unlock();
		}
		
		return res;
	}
	
	public int getValue() {
		valueLock.lock();
		try {
			return value;
		} finally {
			valueLock.unlock();
		}
	}

}
