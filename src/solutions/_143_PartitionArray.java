package src.solutions;

import java.util.Arrays;

public class _143_PartitionArray {

	public static void main(String[] args) {
		
		int[] input = new int[] {6, 14, -1, 12, 5, 10};
		partitionArray(input, 10);
		System.out.println(Arrays.toString(input));
	}
	
	private static void partitionArray(int[] arr, int pivot) {
		
		int low = 0, mid = 0, high = arr.length - 1;
		int temp = -1;
		
		while(mid <= high) {
			
			if(arr[mid] < pivot) {
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			}
			
			else if(arr[mid] == pivot) {
				mid++;
			}
			
			else {
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
			}
			
		}
		
	}

}
