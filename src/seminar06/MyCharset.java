package seminar06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCharset implements Charset {
	
	private List<Character> list;
	
	/**
	 * Inner class for Iterator
	 */
	private class CharsetIterator implements Iterator<Character> {
		
		private int ind = 0;

		@Override
		public boolean hasNext() {
			return ind < list.size();
		}

		@Override
		public Character next() {
			return list.get(ind++);
		}
		
	}
	
	public MyCharset() {
		list = new ArrayList<>();
	}

	@Override
	public boolean contains(char c) {
		return list.contains(new Character(c));
	}
	

	@Override
	public boolean insert(char c) {
		if (contains(c)) {
			return false;
		} else {
			list.add(c);
			return true;
		}
	}

	@Override
	public int insertAll(Charset s) {
		Iterator<Character> it = s.iterator();

		int res = 0;
		while (it.hasNext()) {
			if (insert(it.next())) {
				res++;
			}
		}

		return res;
	}

	@Override
	public boolean remove(char c) {
		return list.remove(new Character(c));
	}

	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Method inherited from Iterator<Character>
	 */
	@Override
	public Iterator<Character> iterator() {
		return new CharsetIterator();
	}
	
}
