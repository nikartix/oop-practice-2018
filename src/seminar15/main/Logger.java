package seminar15.main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger extends Thread {
	
	private BlockingQueue<String> logs;
	
	public Logger(int bufferCapacity) {
		logs = new LinkedBlockingQueue<>(bufferCapacity);
	}

	public Logger() {
		this(Integer.MAX_VALUE);
	}
	
	public void log(String s) {
		try {
			logs.put(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			runLogger();
		} catch (InterruptedException ignored) {
			System.out.println("Logger interrupted 0");
		}
		
		interrupted();	// To clear interrupted flag (try commenting this line to see what happens)
		
		try {
			flush();
		} catch (InterruptedException ignored) {
			System.out.println("Logger interrupted 1");
		}
	}
	
	private void runLogger() throws InterruptedException {
		while (!isInterrupted()) {
			String log = logs.take();
			printLog(log);
		}
	}
	
	private void flush() throws InterruptedException {
		int logsLeft = logs.size();
		while (logsLeft > 0) {
			printLog(logs.take());
			logsLeft--;
		}
	}
	
	private void printLog(String log) {
		System.out.println(log);
	}

}
