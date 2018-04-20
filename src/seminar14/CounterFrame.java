package seminar14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterFrame extends JFrame implements ActionListener {

	private JLabel number;
	private JLabel comment;
	private JButton increment;
	private ConcurrentCounter counter;
	
	public CounterFrame() {
		counter = new ConcurrentCounter(0);
		
		add(buildCenterUI(), BorderLayout.CENTER);
		add(buildSouthUI(), BorderLayout.SOUTH);
	}
	
	public void setComment(String value) {
		comment.setText(value);
		pack();
	}
	
	private Component buildCenterUI() {
		JPanel res = new JPanel();
		BoxLayout layout = new BoxLayout(res, BoxLayout.Y_AXIS);
		res.setLayout(layout);
		
		number = new JLabel(String.valueOf(counter.getValue()));
		number.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 128));
		res.add(number);
		
		comment = new JLabel("");
		comment.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
		comment.setForeground(Color.RED);
		res.add(comment);
		
		return res;
	}

	private Component buildSouthUI() {
		JPanel res = new JPanel(new FlowLayout());
		
		increment = new JButton("UP");
		increment.addActionListener(this);
		res.add(increment);
		
		return res;
	}

	private void onIncrement() {
		number.setText(String.valueOf(counter.increment(1)));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == increment) {
			onIncrement();
		}
	}
	
	public ConcurrentCounter getCounter() {
		return counter;
	}

}
