package seminar05;


public class Person implements Describable, Comparable<Person> {
	
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		System.out.println(String.format("Person by %s %s", firstName, lastName));
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println(descibe());
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Person o) {
		int res = firstName.compareTo(o.getFirstName());
		if (res != 0)
			return res;
		else
			return lastName.compareTo(o.getLastName());
	}

	@Override
	public String descibe() {
		return getFirstName() + " " + getLastName();
	}

}
