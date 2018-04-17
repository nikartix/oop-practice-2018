package seminar10.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StudentsTableModel extends AbstractTableModel {
	
	private List<Student> students;
	
	public StudentsTableModel() {
		students = new ArrayList<Student>();
		students.add(new Student("First Name", "Last Name", 2016));
	}
	
	public void addStudent(Student student) {
		students.add(student);
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 3;	// There are three fields in student class
	}

	@Override
	public int getRowCount() {
		return students.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = students.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return s.getFirstName();
		case 1:
			return s.getLastName();
		case 2:
			return String.valueOf(s.getEnrollmentYear());
		default:
			return "NaN";
		}
	}

}
