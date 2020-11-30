package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * You are given an array of integers, where each element represents the maximum number of steps
 * that can be jumped going forward from that element.
 * Write a function to return the minimum number of jumps you must take in order to get from the start to the end of the array.
 * For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2,
 * as the optimal solution involves jumping from 6 to 5, and then from 5 to 9
 */
public class _245_Jump_Game {

    private static int getMinJumps(int[] jump) {
        //int min = Integer.MAX_VALUE;
        int n = jump.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--) {
            int jumpsNeeded = n - 1 - i;
            int canTake = jump[i];
            if(canTake >= jumpsNeeded)
                dp[i] = 1;
            else {
                for(int j = canTake; j >= 1; j--) {
                    int newIndex = i + j;
                    if(dp[newIndex] == Integer.MAX_VALUE)
                        continue;
                    dp[i] = Math.min(dp[i], 1 + dp[newIndex]);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] jumps = {6, 2, 4, 0, 5, 1, 1, 4, 2, 9};
        int minJumps = getMinJumps(jumps);
        System.out.println(minJumps);
    }

}
