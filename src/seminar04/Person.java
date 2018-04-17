package seminar04;

public class Person implements Nameable, Comparable<Person> {
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return "Person: " + name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
