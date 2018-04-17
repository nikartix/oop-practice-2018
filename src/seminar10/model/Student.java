package seminar10.model;

public class Student {
	
	private String firstName;
	private String lastName;
	private int enrollmentYear;
	
	public Student(String firstName, String lastName, int enrollmentYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.enrollmentYear = enrollmentYear;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

}
