package seminar13;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberFinderImpl implements PrimeNumberFinder {

	@Override
	public List<Long> findPrimesInRange(long start, long end) {
		List<Long> res = new ArrayList<>();
		for (long i = start; i <= end; i++) {
			if (MathUtils.isPrime(i)) {
				res.add(i);
			}
		}
		return res;
	}

	@Override
	public int getThreadCount() {
		return 1;
	}

}
