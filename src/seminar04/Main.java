package seminar04;


public class Main {
	
	public static void main(String[] args) {
		Person person = new Person("John");
		Book book = new Book("Book", "Author");
		
		printNames(person, book, person, book);
	}
	
	private static void printNames(Nameable... nameables) {
		for (Nameable el : nameables) {
			System.out.println(el.getName());
		}
	}
	
	public static int div(int a, int b) {
		return a / b;
	}

}
