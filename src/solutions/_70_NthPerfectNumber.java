package dailyCodingProblem;

public class _70_NthPerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = 10;
		System.out.println("Nth Perfect Number :: " + NthPerfectNumber(N));

	}
	
	private static int NthPerfectNumber(int n) {
		int k = 19;
		if(n == 1)
			return k;
		
		int count = 1;
		while(true) {
			k = k + 9;
			if(getDigitsSum(k) == 10) {
				count++;
			}
			if(count == n) {
				return k;
			}
		}
	}
	
	private static int getDigitsSum(int number) {
		int sum = 0;
		while(number > 0) {
			sum = sum + number % 10;
			number = number/ 10;
		}
		return sum;
	}

}
