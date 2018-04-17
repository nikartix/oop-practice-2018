package seminar07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class Vector implements Iterable<Number> {
	
	private List<Number> vector;

	public Vector(List<Number> vector) {
		this.vector = vector;
	}

	@SafeVarargs
	public Vector(Number... vector) {
		this(Arrays.asList(vector));
	}
	
	public Vector(int size, Number value) {
		this(new ArrayList<Number>(size));

		for (int i = 0; i < size; i++) {
			vector.set(i, value);
		}
	}
	
	public int size() {
		return vector.size();
	}
	
	public Number get(int i) {
		return vector.get(i);
	}

	private Vector apply(Vector b, BiFunction<Number, Number, Number> f) {
		assert size() == b.size();
		List<Number> res = new ArrayList<>();

		for (int i = 0; i < size(); i++) {
			res.add(f.apply(get(i), b.get(i)));
		}

		return new Vector(res);
	}
	
	public Vector add(Vector v) {
		return apply(v, (a, b) -> a.add(b));
	}

	public Vector sub(Vector v) {
		return apply(v, (a, b) -> a.sub(b));
	}

	public Vector mul(Vector v) {
		return apply(v, (a, b) -> a.mul(b));
	}

	public Vector div(Vector v) {
		return apply(v, (a, b) -> a.div(b));
	}
	
	public Number dot(Vector v) {
		return mul(v).vector.stream().reduce(
				new RealNumber(0.0), 
				(result, el) -> result.add(el)
				);
	}
	
	@Override
	public String toString() {
		return vector.toString();
	}

	@Override
	public Iterator<Number> iterator() {
		return vector.iterator();
	}
	
}
