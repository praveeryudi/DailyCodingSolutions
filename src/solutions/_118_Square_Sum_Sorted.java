package dailyCodingProblem;

import java.util.Arrays;

public class _118_Square_Sum_Sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[] {-9, -2, 0, 2, 3};
		int[] res = new int[input.length];
		
		int k = input.length - 1;
		int left = 0;
		int right = input.length - 1;
		
		while(left < right) {
			int x = Math.abs(input[left]);
			int y = Math.abs(input[right]);
			
			if(x <= y) {
				res[k] = y * y;
				right--;
			}
			else {
				res[k] = x * x;
				left++;
			}
			k--;
		}

		System.out.println(Arrays.toString(res));
		
	}

}
