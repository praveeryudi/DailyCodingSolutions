package src.solutions.dailySolutions;

import java.util.Arrays;

public class _1_HasTargetSumPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {10, 15, 3, 7};
		int k = 17;
		System.out.println("Has Target Sum :: " + hasTargetSum(arr, k));
	}
	
	private static boolean hasTargetSum(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		
		while(left < right) {
			if(nums[left] + nums[right] == target)
				return true;
			else if(nums[left] + nums[right] > target) {
				right--;
			}
			else {
				left ++;
			}
		}
		return false;
	}

}
