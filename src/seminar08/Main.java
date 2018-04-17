package seminar08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
	
	private int twice(Integer x) {
		return x * 2;
	}
	
	private Main() {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2, 3, 4));
		final List<Integer> list2 = new ArrayList<>();
		
		Stream<String> s = list.stream()
				.map((i) -> i.toString());
		
		for (Integer el : list) {
			System.out.println(el);
		}
		
		list.forEach((el) -> { 
			System.out.println(el);
		});

		list.forEach(new Consumer<Integer>() {
			
			private int var = 10;
			
			@Override
			public void accept(Integer t) {
//				int v = Main.this.twice(t);		// Call outer method of outer class
				int v = twice(t);
				System.out.println(v);
				
				new Iterator<Integer>() {

					@Override
					public boolean hasNext() {
						int var = 20;
						// Can't access outer var because anonymous class has no name
						return false;
					}

					@Override
					public Integer next() {
						return null;
					}
				};
				
				list2.add(v);
			}
			
			private int twice(Integer i) {
				return i * 2;
			}

		});
	}

	public static void main(String[] args) {
		new Main();
	}

}
