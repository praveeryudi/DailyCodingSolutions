package src.solutions.myOwn;

/**
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once.
 * You must buy before you can sell it.
 *
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5,
 * since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class _47_BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 10};
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        System.out.println("Profit: " + profit);
    }

}
