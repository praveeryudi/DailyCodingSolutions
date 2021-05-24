package src.solutions.dailySolutions;

/**
 * Implement integer exponentiation. That is, implement the pow(x, y) function,
 * where x and y are integers and returns x^y.
 *
 * Do this faster than the naive method of repeated multiplication.
 *
 * For example, pow(2, 10) should return 1024.
 */
public class _61_Exponentiation {

	public static void main(String[] args) {
		long result = power(2, 4);
		System.out.println("Result = " + result);
	}
	
	static long power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        long temp = power(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
	}

}
