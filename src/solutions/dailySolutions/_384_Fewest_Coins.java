package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * You are given an array of integers representing coin denominations and a total amount of money.
 * Write a function to compute the fewest number of coins needed to make up that amount.
 * If it is not possible to make that amount, return null.
 *
 * For example, given an array of [1, 5, 10] and an amount 56, return 7 since we can use 5 dimes, 1 nickel, and 1 penny.
 *
 * Given an array of [5, 8] and an amount 15, return 3 since we can use 5 5-cent coins.
 */
public class _384_Fewest_Coins {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 10;
        int res = getFewestCoins(coins, amount);
        System.out.println("Fewest Coins :" + res);
    }

    private static int getFewestCoins(int[] coins, int amount) {

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int index = 1; index <= amount; index++) {
            int targetSum = index;
            for(int c = 0; c < coins.length; c++) {
                if(coins[c] > targetSum)
                    break;
                int remSum = targetSum - coins[c];
                dp[index] = Math.min(dp[index], 1 + dp[remSum]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

}
