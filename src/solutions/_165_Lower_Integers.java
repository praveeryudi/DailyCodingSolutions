package src.solutions;

import java.util.Arrays;

public class _165_Lower_Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {3, 4, 9, 6, 1};
		
		int len = arr.length;
		int[] output = new int[len];
		output[len-1] = 0;
		for(int k = len-2; k >= 0; k--) {
			
			int num = arr[k];
			int count = 0;
			for(int index = k+1; index < len; index++) {
				if(arr[index] < num)
					count++;
			}
			output[k] = count;
		}

		System.out.println(Arrays.toString(output));
		
	}

}
