package seminar13;

import java.util.List;

public interface PrimeNumberFinder {
	
	/**
	 * Finds all prime numbers in range [start, end]
	 * @param start - Start positive number (inclusive)
	 * @param end - End positive number (inclusive)
	 * @return List of prime numbers in range [start, end]
	 */
	List<Long> findPrimesInRange(long start, long end);
	
	/**
	 * @return Number of threads working on finding prime numbers.
	 */
	int getThreadCount();
	
}
