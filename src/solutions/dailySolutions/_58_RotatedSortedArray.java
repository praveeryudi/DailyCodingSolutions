package src.solutions.dailySolutions;

public class _58_RotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] {13,18,25,2,8,10};
		int n = 10;
		
		//int idx = findIndex(nums, n, 0, nums.length - 1);
		//System.out.println("Got Index:: " + idx);
		
		int idx = findIndexIterative(nums, n);
		System.out.println("Got Index 2:: " + idx);
	}
	
	private static int findIndexIterative(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == target)
				return mid;
			
			if(arr[low] <= arr[mid]) {
				if(target >= arr[low] && target < arr[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
			else {
				if(target > arr[mid] && target <= arr[high])
					low = mid + 1;
				else
					high = mid -1;
			}
		}
		return -1;
	}
	
	private static int findIndex(int[] arr, int number, int low, int high) {
		if(low > high)
			return -1;
		
		int mid = low + (high-low)/ 2;
		if(arr[mid] == number)
			return mid;
		
		if(arr[low] <= arr[mid]) {
			if(number >= arr[low] && number < arr[mid])
				return findIndex(arr, number, low, mid-1);
			else
				return findIndex(arr, number, mid+1, high);
		}
		else {
			if(number > arr[mid] && number <= arr[high])
				return findIndex(arr, number, mid+1, high);
			else
				return findIndex(arr, number, low, mid-1);
		}
	}

}
