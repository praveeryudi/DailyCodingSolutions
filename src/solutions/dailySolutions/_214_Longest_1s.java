package src.solutions.dailySolutions;

public class _214_Longest_1s {

	public static void main(String[] args) {

		int num = 156;
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			int digit = num % 2;
			sb.append(digit);
			num = num / 2;
		}
		String binary = sb.reverse().toString();
		char[] chars = binary.toCharArray();
		int[] dp = new int[chars.length];
		int max = Integer.MIN_VALUE;
		dp[0] = chars[0];
		for(int index = 1; index < chars.length; index++) {
			dp[index] = chars[index] == '0' ? 0 : 1 + dp[index-1];
			max = Math.max(max, dp[index]);
		}
		System.out.println("Longest length of consecutive 1s = " + max);
	}
}