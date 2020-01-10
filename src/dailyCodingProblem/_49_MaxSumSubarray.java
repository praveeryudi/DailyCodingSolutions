package dailyCodingProblem;

public class _49_MaxSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {34, -50, 42, 14, -5, 86};
		System.out.println("Max Sum :: " + getMaxSum(arr));
	}
	
	/**
	 * Compute max sub-array sum using Kadane's algorithm.
	 * @param nums
	 * @return integer
	 */
	private static int getMaxSum(int[] nums) {
		
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int index = 0; index < nums.length; index++) {
			currSum += nums[index];
			if(currSum < 0)
				currSum = 0;
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}

}
