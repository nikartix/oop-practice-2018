package seminar06;

public class Main {
	
	public static void main(String[] args) {
		Charset set = new MyCharset();
		
		for (char c = 'a'; c <= 'f'; c++) {
			set.insert(c);
		}
		
		System.out.println("a in set => " + set.contains('a'));
		System.out.println("b in set => " + set.contains('b'));
		System.out.println("g in set => " + set.contains('g'));
		
		System.out.println("remove a => " + set.remove('a'));

		System.out.println("a in set => " + set.contains('a'));

		System.out.println("set size => " + set.size());
		
		for (Character c : set) {
			System.out.print(" " + c);
		}
	}

}
