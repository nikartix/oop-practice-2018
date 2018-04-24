package seminar15.main;

public class LoggingThread extends Thread {
	
	private Logger logger;
	private int logSize;
	
	public LoggingThread(String name, Logger logger, int logSize) {
		super(name);
		this.logger = logger;
		this.logSize = logSize;
	}

	public void run() {
		for (int i = 1; i <= logSize; i++) {
			logger.log(getName() + "-" + i);
		}
	}

}
