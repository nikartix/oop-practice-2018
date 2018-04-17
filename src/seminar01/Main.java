package seminar01;

public class Main {
	
	private static void doIt(int x) {
		x++;
	}
	
	private static void doIt(Ricxvi r) {
		r.x++;
	}
	
	public static void main(String[] args) {
		
		int x0;
		Ricxvi r0 = new Ricxvi();
		
		x0 = 10;
		r0.x = 10;
		
		doIt(x0);
		doIt(r0);

		System.out.println(x0);
		System.out.println(r0.x);
	}

}
