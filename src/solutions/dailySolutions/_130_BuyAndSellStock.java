package solutions.dailySolutions;

/**
 * Given an array of numbers representing the stock prices of a company in chronological order and an integer k,
 * return the maximum profit you can make from k buys and sells. You must buy the stock before you can sell it,
 * and you must sell the stock before you can buy it again.
 *
 * For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.
 */
public class _130_BuyAndSellStock {

    private static int getMaxProfit(int[] prices, int k) {
        int rows = k + 1;
        int cols = prices.length;

        int[][] dp = new int[rows][cols];
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                // Case 1. Do not buy
                int noBuy = dp[i][j-1];
                // Case 2. Buy
                int buy = 0;
                for(int m = 0; m <= j; m++) {
                    buy = Math.max(buy, prices[j] - prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(noBuy, buy);
            }
        }
        return dp[k][prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {5,2,4,0,1};
        int profit = getMaxProfit(prices, 2);
        System.out.println("Max Profit " + profit);
    }

}
