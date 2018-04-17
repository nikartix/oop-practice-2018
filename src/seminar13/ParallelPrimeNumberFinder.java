package seminar13;

import java.util.ArrayList;
import java.util.List;

public class ParallelPrimeNumberFinder implements PrimeNumberFinder {
	
	private PrimeNumberFinder primeFinder;
	private int nThreads;
	
	private class Worker extends Thread {
		
		private long start, end;
		private List<Long> out;
		
		Worker(long start, long end) {
			this.start = start;
			this.end = end;
			this.out = null;
		}
		
		@Override
		public void run() {
			out = primeFinder.findPrimesInRange(start, end);
		}
		
	}
	
	/**
	 * Constructor taking prime number finder and number of threads
	 * 	to parallelize calculations.
	 * @param primeFinder - Prime number finder
	 * @param nThreads - Number of threads to work with
	 */
	public ParallelPrimeNumberFinder(PrimeNumberFinder primeFinder, int nThreads) {
		this.primeFinder = primeFinder;
		this.nThreads = nThreads;
	}
	
	private List<Worker> launchWorkers(long start, long end) {
		long totalNumbers = end - start + 1;
		long workerAmount = (totalNumbers + nThreads - 1) / nThreads;
		List<Worker> workers = new ArrayList<>();
		
		for (int i = 0; i < nThreads; i++) {
			Worker worker = new Worker(i * workerAmount, Math.min((i + 1) * workerAmount, end));
			worker.start();
			workers.add(worker);
		}
		
		return workers;
	}

	@Override
	public List<Long> findPrimesInRange(long start, long end) {
		
		// Launching threads
		List<Worker> workers = launchWorkers(start, end);

		// Waiting for all of them to finish execution
		try {
			for (Worker w : workers) {
				w.join();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException("Interrupted while finding primes!", e);
		}
		
		// Combining results
		List<Long> primes = new ArrayList<>();
		for (Worker w : workers) {
			primes.addAll(w.out);
		}

		return primes;
	}

	@Override
	public int getThreadCount() {
		return nThreads;
	}

}
