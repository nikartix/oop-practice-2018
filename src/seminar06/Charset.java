package seminar06;

public interface Charset extends Iterable<Character> {
	
	/**
	 * @param c - character
	 * @return True if set contains character.
	 */
	boolean contains(char c);
	
	/**
	 * @param c
	 * @return True if set contains character.
	 */
	boolean insert(char c);
	
	int insertAll(Charset s);
	
	boolean remove(char c);
	
	int size();

}
