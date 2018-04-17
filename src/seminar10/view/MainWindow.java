package seminar10.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import seminar10.model.Student;

public class MainWindow extends JFrame implements ActionListener {
	
	private JTable table;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField enrollmentYearField;
	private JButton addButton;
	
	private List<StudentCreationListener> studentCreationListeners;
	
	private JComponent buildSourth() {
		JPanel res = new JPanel(new FlowLayout());

		firstNameField = new JTextField(10);
		lastNameField = new JTextField(10);
		enrollmentYearField = new JTextField(10);
		addButton = new JButton("Add");
		
		addButton.addActionListener(this);

		res.add(new JLabel("First Name: "));
		res.add(firstNameField);
		res.add(new JLabel("Last Name: "));
		res.add(lastNameField);
		res.add(new JLabel("Enrollment Year: "));
		res.add(enrollmentYearField);
		res.add(addButton);

		return res;
	}
	
	public MainWindow(TableModel tableModel) {
		studentCreationListeners = new ArrayList<StudentCreationListener>();
		
		table = new JTable(tableModel);
		add(table);

		add(buildSourth(), BorderLayout.SOUTH);
		
		tableModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				MainWindow.this.pack();
			}
		});
	}
	
	public void initDisplay() {
		SwingUtilities.invokeLater(() -> {
			MainWindow.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MainWindow.this.pack();
			MainWindow.this.setVisible(true);
		});
	}
	
	public void addStudentCreationListener(StudentCreationListener listener) {
		studentCreationListeners.add(listener);
	}
	
	private void notifyStudentCreation(Student student) {
		for (StudentCreationListener l : studentCreationListeners) {
			l.onStudentAdded(student);
		}
	}
	
	private void addStudent() throws Exception {
		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();
		String enrollmentYearStr = enrollmentYearField.getText();
		int enrollmentYear;
		
		if ("".equals(firstName)) {
			throw new Exception("First name mustn't be blank!");
		}
		if ("".equals(lastName)) {
			throw new Exception("Last name mustn't be blank!");
		}

		try {
			enrollmentYear = Integer.parseInt(enrollmentYearStr);
		} catch (NumberFormatException e) {
			throw new Exception("Enrollment year is not an integer", e);
		}
		
		notifyStudentCreation(new Student(firstName, lastName, enrollmentYear));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == addButton) {
			try {
				addStudent();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
