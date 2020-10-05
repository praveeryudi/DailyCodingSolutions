package src.solutions.dailySolutions;

import java.util.Arrays;

public class _29_RunLengthEncoding {

	public static void main(String[] args) {
		
		String str = "AAADDDBBCEEE";
		int[] count = new int[26];
		Arrays.fill(count, 0);
		
		for(char ch : str.toCharArray()) {
			count[ch - 'A'] = count[ch - 'A'] + 1;
		}

		for(int index = 0; index < count.length; index++) {
			if(count[index] > 0) {
				char ch = (char)(index + 65);
				System.out.println(count[index] + "" + ch);
			}
		}
	}

}
