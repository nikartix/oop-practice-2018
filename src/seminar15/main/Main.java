package seminar15.main;

public class Main {
	
	private static void interruptingThead() {
		// Interruption example
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000000 && !isInterrupted(); i++) {
					System.out.println(i);
				}
			}
		};
		
		thread.start();
		
		try {
			Thread.sleep(1000);
			thread.interrupt();
			
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void multithreadLogging() {
		Logger logger = new Logger(1000);
		logger.start();
		
		int logSize = 100;
		LoggingThread[] threads = new LoggingThread[] {
				new LoggingThread("thread1", logger, logSize),
				new LoggingThread("thread2", logger, logSize),
				new LoggingThread("thread3", logger, logSize),
				new LoggingThread("thread4", logger, logSize),
		};
		
		for (LoggingThread t : threads) {
			t.start();
		}

		try {
			for (LoggingThread t : threads) {
				t.join();
			}
			System.out.println("# All Theads done");
			logger.interrupt();
			logger.join();			// Interrupt method interrupts logger asynchronously. Need to join.
			System.out.println("# Logger Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		multithreadLogging();
	}

}
