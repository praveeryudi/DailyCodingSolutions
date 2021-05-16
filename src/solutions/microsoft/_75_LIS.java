package src.solutions.microsoft;

import java.util.Arrays;

/**
 * Given an array of numbers, find the length of the longest increasing subsequence in the array.
 * The subsequence does not necessarily have to be contiguous.
 *
 * For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15],
 * the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class _75_LIS {

    private static int getLIS(int[] nums) {

        int max = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int start = 1; start < n; start++) {
            int end = 0;
            while(end < start) {
                if(nums[start] > nums[end]) {
                    dp[start] = Math.max(dp[start], 1 + dp[end]);
                }
                end++;
            }
            max = Math.max(max, dp[start]);
        }
        return max;
    }

}
