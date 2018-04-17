package seminar04;

public class Book implements Nameable {
	
	private String name;
	private String author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	@Override
	public String getName() {
		return "Book: " + name + " by " + author;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
