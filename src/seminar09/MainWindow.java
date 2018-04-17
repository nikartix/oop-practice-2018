package seminar09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {
	
	private static final String BUTTON_TITLE = "Change";
	private static final String DEFAULT_LABEL = "Hello, World";
	
	private JLabel label;
	private JTextField field;
	private JButton button;
	
	private class TextChangeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = field.getText();
			if (!"".equals(text)) {
				label.setText(text);
				field.setText("");
			}
		}
		
	}
	
	private JComponent buildCenter() {
		label = new JLabel(DEFAULT_LABEL, JLabel.CENTER);
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
		return label;
	}
	
	private JComponent buildSouth() {
		JPanel res = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ActionListener textChangeListener = new TextChangeListener();
		
		field = new JTextField(20);
		field.addActionListener(textChangeListener);
		res.add(field);

		button = new JButton(BUTTON_TITLE);
		button.addActionListener(textChangeListener);
		res.add(button);

		return res;
	}
	
	public MainWindow() {
		add(buildCenter(), BorderLayout.CENTER);
		add(buildSouth(), BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new MainWindow();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		});
	}

}
