package seminar05;

public class President extends Person {
	
	private int electionYear;
	
	public President(String firstName, String lastName, int electionYear) {
		super(firstName, lastName);
		this.electionYear = electionYear;
		System.out.println("President default constructor");
	}
	
	@Override
	public String descibe() {
		return super.descibe() + " elected at " + electionYear;
	}

}
