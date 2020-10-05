package src.solutions.dailySolutions;

public class _47_BuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prices = new int[] {9,11,8,5,7,10};
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int index = 0; index < prices.length; index++) {
			if(prices[index] < min) {
				min = prices[index];
			}
			else {
				max = Math.max(max, prices[index] - min);
			}
		}
		System.out.println("Max Profit - " + max);
	}

}
