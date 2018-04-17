package seminar13;

public class MathUtils {
	
	public static boolean isPrime(long n) {
		for (long i = 2; i * i <= n; ++i) {
			if (n % i == 0)
				return false;
		}

		return n >= 2;
	}

}
