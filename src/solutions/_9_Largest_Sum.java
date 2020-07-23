package src.solutions;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
 * [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */
public class _9_Largest_Sum {

    public static void main(String[] args) {
        int[] nums = {2,4,6,2,5};

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        int largestSum = dp[nums.length - 1];
        System.out.println("Largest Sum = " + largestSum);
    }
}
