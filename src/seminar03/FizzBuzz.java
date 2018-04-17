package seminar03;

public class FizzBuzz {
	
	public String evaluate(int number) {
		if (isDivisibleBy(number, 3) && isDivisibleBy(number, 5)) {
			return "FizzBuzz";
		} else if (isDivisibleBy(number, 3)) {
			return "Fizz";
		} else if (isDivisibleBy(number, 5)) {
			return "Buzz";
		}
		return String.valueOf(number);
	}
	
	private boolean isDivisibleBy(int m, int n) {
		return m % n == 0;
	}

}
