package src.solutions.myOwn;

import java.util.ArrayList;
import java.util.List;

public class MinimizeSubsetSum {

    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = {2,4,4,3};
        minimizeSumBacktrack(nums, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println("Min Diff (Backtrack): " + minDiff);
        int minimumDiff = minimizeSumDP(nums);
        System.out.println("Min Diff (DP): " + minimumDiff);
    }

    // Backtracking - gives TLE
    private static void minimizeSumBacktrack(int[] nums, int index, List<Integer> set1, List<Integer> set2, int sum1, int sum2) {

        if(index == nums.length) {
            int delta = Math.abs(sum1 - sum2);
            if(delta < minDiff) {
                minDiff = delta;
                System.out.println(set1 + " : " + set2);
            }
            return;
        }

        set1.add(nums[index]);
        minimizeSumBacktrack(nums, index + 1, set1, set2, sum1 + nums[index], sum2);
        set1.remove(set1.size() - 1);

        set2.add(nums[index]);
        minimizeSumBacktrack(nums, index + 1, set1, set2, sum1, sum2 + nums[index]);
        set2.remove(set2.size() - 1);

    }

    private static int minimizeSumDP(int[] nums) {

        int total = 0;
        for(int i : nums) {
            total += i;
        }
        int target = total / 2;
        int rows = nums.length;
        int cols = 1 + target; // to consider 0 sum

        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;
        // First row
        for(int c = 1; c < cols; c++) {
            if(nums[0] == c) {
                dp[0][c] = true;
            }
        }
        // First column
        for(int r = 1; r < rows; r++) {
            dp[r][0] = true;
        }

        // Remaining cells
        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(nums[r] > c) {
                    dp[r][c] = dp[r-1][c];
                }
                else {
                    boolean exclude = dp[r-1][c];
                    boolean include = dp[r-1][c - nums[r]];
                    dp[r][c] = exclude || include;
                }
            }
        }

        // Iterate backwards in last row
        int lastRow = rows - 1;
        int c;
        for(c = cols - 1; c >= 0; c--) {
            if(dp[lastRow][c]) {
                break;
            }
        }

        int firstSum = c;
        int secondSum = total - firstSum;
        return Math.abs(firstSum - secondSum);
    }

}
