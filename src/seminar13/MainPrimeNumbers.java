package seminar13;

import java.util.List;

public class MainPrimeNumbers {
	
	private static final int N_THREADS = 2;

	private static final long RANGE_BEGIN = 1;
	private static final long RANGE_END = RANGE_BEGIN + 10000000L;
	
	private static PrimeNumberFinder buildPrimeNumberFinder() {
		PrimeNumberFinder finder = new PrimeNumberFinderImpl();

		// TODO: When done implementing ParallelPrimeNumberFinder uncomment next line:
		finder = new ParallelPrimeNumberFinder(finder, N_THREADS);

		return finder;
	}
	
	/*
	 * Approximate prime number count in range [start, end]
	 * According to prime number theorem: https://en.wikipedia.org/wiki/Prime_number_theorem
	 */
	private static long approxPrimeCount(long start, long end) {
		start = Math.max(2, start);
		return (long) ((end / Math.log(end)) - (start / Math.log(start)));
	}
	
	public static void main(String[] args) {
		PrimeNumberFinder primeFinder = buildPrimeNumberFinder();

		long start = System.currentTimeMillis();
		List<Long> primes = primeFinder.findPrimesInRange(RANGE_BEGIN, RANGE_END);
		long elapsed = System.currentTimeMillis() - start;
		long approxPrimes = approxPrimeCount(RANGE_BEGIN, RANGE_END);

		System.out.println(String.format("In range [%d, %d] found %d primes ~ %d", RANGE_BEGIN, RANGE_END, primes.size(), approxPrimes));
		System.out.println(String.format("Time elapsed: %f seconds", elapsed / 1000.0));
		System.out.println(String.format("Threads: %d", primeFinder.getThreadCount()));
		
		// Uncomment this to print all prime numbers
//		for (Integer p : primes) {
//			System.out.println(p);
//		}
	}

}
