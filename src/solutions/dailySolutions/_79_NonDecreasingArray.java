package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.
 *
 * For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.
 *
 * Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.
 */
public class _79_NonDecreasingArray {

	public static void main(String[] args) {

		int[] nums = {10, 5, 1};
		boolean res = isPossible(nums);
		System.out.println(res);

	}

	private static boolean isPossible(int[] nums) {
		if (null == nums || nums.length == 0)
			return true;

		int errorPos = getErrorPosition(nums);
		if (errorPos == -1)
			return true;

		int errorVal = nums[errorPos];
		nums[errorPos] = nums[errorPos + 1];
		System.out.println(Arrays.toString(nums));

		if (getErrorPosition(nums) == -1)
			return true;

		nums[errorPos] = errorVal;
		nums[errorPos + 1] = errorVal;
		System.out.println(Arrays.toString(nums));
		
		if (getErrorPosition(nums) == -1)
			return true;
		return false;
	}

	private static int getErrorPosition(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i+1])
				return i;
		}
		return -1;
	}

}
