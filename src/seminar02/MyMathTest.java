package seminar02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyMathTest {
	
	static private MyMath math;
	
	@BeforeAll
	static void setUp() {
		math = new MyMath();
	}
	
	@Test
	void testModZero() {
		assertEquals(0, math.mod(5, 5));
	}
	
	@Test
	void testModOne() {
		assertEquals(1, math.mod(6, 5));
	}
	
	@Test
	void testModOfNegative() {
		assertEquals(3, math.mod(-1, 4));
	}
	
	@Test
	void testModOfLargeNegative() {
		assertEquals(2, math.mod(-5, 4));
	}
	
}
