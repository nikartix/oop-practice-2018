package seminar07;

public class Main {
	
	public static void main(String[] args) {
		Number n0 = new RealNumber(5.0);
		Number n1 = new RealNumber(6.0);
		
		printOperations(n0, n1);
		
		Number cn0 = new ComplexNumber(2.0, 1.0);
		Number cn1 = new ComplexNumber(3.0, 4.0);
		
		System.out.println();
		printOperations(cn0, cn1);
		
		Vector v0 = new Vector(n0, n1);
		Vector v1 = new Vector(n1, n0);
		Vector v2 = new Vector(cn0, cn1);

		System.out.println();
		printVectorOperations(v0, v1);

		System.out.println();
		printVectorOperations(v1, v2);
	}
	
	private static void printOperations(Number n0, Number n1) {
		System.out.println("(" + n0 + ") * (" + n1 + ") = " + n0.mul(n1));
		System.out.println("(" + n0 + ") / (" + n1 + ") = " + n0.div(n1));
		System.out.println("(" + n0 + ") + (" + n1 + ") = " + n0.add(n1));
		System.out.println("(" + n0 + ") - (" + n1 + ") = " + n0.sub(n1));
	}

	private static void printVectorOperations(Vector v0, Vector v1) {
		System.out.println(v0 + " * " + v1 + " = " + v0.mul(v1));
		System.out.println(v0 + " / " + v1 + " = " + v0.div(v1));
		System.out.println(v0 + " + " + v1 + " = " + v0.add(v1));
		System.out.println(v0 + " - " + v1 + " = " + v0.sub(v1));
		System.out.println(v0 + " dot " + v1 + " = " + v0.dot(v1));
	}
	
}
