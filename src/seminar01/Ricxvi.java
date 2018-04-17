package seminar01;

public class Ricxvi {
	
	public int x;
	
	@Override
	public boolean equals(Object r) {
		if (r == null)
			return false;
		return r.getClass() == getClass() && x == ((Ricxvi) r).x;
	}
	
}
