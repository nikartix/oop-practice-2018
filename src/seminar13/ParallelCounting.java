package seminar13;

public class ParallelCounting {
	
	private static final Object counterLock = new Object();			// Object used to lock access to counter
	private static Integer counter = 0;
	
	private static Thread job1 = new Thread(() -> {					// Using Java 8 lambda expression
		for (int i = 0; i < 10000; i++) {
			synchronized (counterLock) {
				counter++;
			}

			Thread.yield();
		}
	});

	private static Thread job2 = new Thread(new Runnable() {		// Anonymous Runnable class
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				synchronized (counterLock) {
					counter++;
				}
				
				Thread.yield();
			}
		}
	});
	
	public static void main(String[] main) {
		job1.start();
		job2.start();
		
		try {
			job1.join();
			job2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(counter);
	}

}

