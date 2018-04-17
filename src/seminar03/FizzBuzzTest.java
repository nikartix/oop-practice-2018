package seminar03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
	
	static private FizzBuzz fizzBazz;
	
	@BeforeAll
	static void setUp() {
		fizzBazz = new FizzBuzz();
	}
	
	@Test
	void testOne() {
		assertEquals("1", fizzBazz.evaluate(1));
	}
	
	@Test
	void testTwo() {
		assertEquals("2", fizzBazz.evaluate(2));
	}
	
	@Test
	void testThree() {
		assertEquals("Fizz", fizzBazz.evaluate(3));
	}
	
	@Test
	void testFive() {
		assertEquals("Buzz", fizzBazz.evaluate(5));
	}
	
	@Test
	void testSix() {
		assertEquals("Fizz", fizzBazz.evaluate(6));
	}
	
	@Test
	void testTen() {
		assertEquals("Buzz", fizzBazz.evaluate(10));
	}

	@Test
	void testFifteen() {
		assertEquals("FizzBuzz", fizzBazz.evaluate(15));
	}
	
	@Test
	void testThirty() {
		assertEquals("FizzBuzz", fizzBazz.evaluate(30));
	}
	
}

