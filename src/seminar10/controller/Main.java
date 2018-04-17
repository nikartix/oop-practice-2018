package seminar10.controller;

import seminar10.model.Student;
import seminar10.model.StudentsTableModel;
import seminar10.view.MainWindow;
import seminar10.view.StudentCreationListener;

public class Main implements StudentCreationListener {
	
	private StudentsTableModel tableModel;
	
	public Main(StudentsTableModel tableModel, MainWindow mainWindow) {
		this.tableModel = tableModel;

		mainWindow.addStudentCreationListener(this);		// Listening to view event
		mainWindow.initDisplay();							// Initialize/Show display
	}
	
	@Override
	public void onStudentAdded(Student student) {
		tableModel.addStudent(student);						// Updating model
	}
	
	public static void main(String[] args) {
		StudentsTableModel tableModel = new StudentsTableModel();
		MainWindow mainWindow = new MainWindow(tableModel);
		new Main(tableModel, mainWindow);
	}

}
