package dailyCodingProblem;

public class _129_Square_Root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 25;
		System.out.println("Square Root = " + squareRoot(num));
		
	}
	
	private static int squareRoot(int n) {
		if(n <= 0)
			return 0;
		
		int start = 0;
		int end = n;
		
		while(start <= end) {
			int mid = start + (end - start)/ 2;
			int sqr = mid * mid;
			if(sqr == n)
				return mid;
			
			if(sqr < n) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
