package dailyCodingProblem;

public class _61_Exponentiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
