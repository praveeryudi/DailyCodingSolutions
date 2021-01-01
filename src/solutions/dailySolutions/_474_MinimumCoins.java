package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Find the minimum number of coins required to make n cents.
 *
 * You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
 *
 * For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
 */
public class _474_MinimumCoins {

    private static int getMinCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[1 + amount];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int index = 1; index <= amount; index++) {
            for (int coin : coins) {
                if (coin > index)
                    break;
                int remAmount = index - coin;
                dp[index] = Math.min(dp[index], 1 + dp[remAmount]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int numberOfCoins = getMinCoins(coins, 16);
        System.out.println("Min number of coins = " + numberOfCoins);
    }

}
