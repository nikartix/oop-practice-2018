package seminar14;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class Main {
	
	private static boolean pred1(Integer x) {
		return x == 1;
	}

	private static boolean pred2(Integer x) {
		return x == 2;
	}

	private static boolean pred3(Integer x) {
		return x > 2 && x % 2 == 0;
	}

	private static boolean pred4(Integer x) {
		return x > 2 && x % 2 != 0;
	}
	
	public static void main(String[] args) {
		CounterFrame frame = new CounterFrame();
		BackgroundThread thread1 = new BackgroundThread(frame, Main::pred1, "It's 1");
		BackgroundThread thread2 = new BackgroundThread(frame, Main::pred2, "It's 2");
		BackgroundThread thread3 = new BackgroundThread(frame, Main::pred3, "It's even");
		BackgroundThread thread4 = new BackgroundThread(frame, Main::pred4, "It's odd");
		
		SwingUtilities.invokeLater(() -> {
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			Thread.sleep(1000);		// 1 second sleep.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(() -> {
			frame.setComment("DONE");	// All conditions have occurred at least once.
		});
	}

}
