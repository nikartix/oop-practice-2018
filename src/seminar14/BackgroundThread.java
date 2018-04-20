package seminar14;

import java.util.function.Predicate;

import javax.swing.SwingUtilities;

public class BackgroundThread extends Thread {
	
	private CounterFrame frame;
	private Predicate<Integer> waitFor;
	private String message;
	
	public BackgroundThread(CounterFrame frame, Predicate<Integer> predicate, String message) {
		this.frame = frame;
		this.waitFor = predicate;
		this.message = message;
	}
	
	@Override
	public void run() {
		try {
			frame.getCounter().waitFor(this.waitFor);
			
			SwingUtilities.invokeLater(() -> {
				frame.setComment(message);
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
