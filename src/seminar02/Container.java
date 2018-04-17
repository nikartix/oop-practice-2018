package seminar02;

public class Container <K, V> {
	
	private K key;
	private V value;
	
	public Container(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	private <I> void print(I x) {
		System.out.println(x.toString());
	}
	
	@Override
	public String toString() {
		return key.toString() + " -> " + value.toString();
	}
	
}
