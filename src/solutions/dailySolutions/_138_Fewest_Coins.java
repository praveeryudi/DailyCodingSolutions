package solutions.dailySolutions;

import java.util.Arrays;

/**
 * Find the minimum number of coins required to make n cents.
 *
 * You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
 *
 * For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
 */
public class _138_Fewest_Coins {

    public static void main(String[] args) {
        int[] coins = {1,5,10};
        int amount = 56;
        int res = getMinimumCoins(coins, amount);
        System.out.println("Minimum coins = " + res);
    }

    private static int getMinimumCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int index = 1; index <= amount; index++) {
            int target = index;
            for(int c = 0; c < coins.length; c++) {
                if(coins[c] > target)
                    break;
                int rem = target - coins[c];
                dp[index] = Math.min(dp[index], 1 + dp[rem]);
            }
        }
        return dp[amount];
    }

}
