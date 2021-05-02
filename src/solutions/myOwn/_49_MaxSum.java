package src.solutions.myOwn;

/**
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 *
 * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
 * since we would take elements 42, 14, -5, and 86.
 *
 * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
 *
 * Do this in O(N) time.
 */
public class _49_MaxSum {

    public static void main(String[] args) {
        int[] nums = {34, -50, 42, 14, -5, 86};
        // Kadane's Algo
        int max = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }
        System.out.println("Max Sum: " + max);
    }

}
