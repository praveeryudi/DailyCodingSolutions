package dailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class _96_Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		int[] arr = new int[] {1,2,3};
		getPermutations(arr, 0, results);
		for(List<Integer> l : results) {
			System.out.println(l.toString());
		}
	}
	
	private static void getPermutations(int[] nums, int startIndex, List<List<Integer>> results) {
		if(startIndex == nums.length-1) {
			List<Integer> current = new ArrayList<Integer>();
			for(Integer i : nums) {
				current.add(i);
			}
			results.add(current);
			return;
		}
		for(int i = startIndex; i < nums.length; i++) {
			
			// swap
			int t = nums[startIndex];
			nums[startIndex] = nums[i];
			nums[i] = t;
			
			getPermutations(nums, startIndex + 1, results);
			
			// swap
			int t1 = nums[startIndex];
			nums[startIndex] = nums[i];
			nums[i] = t1;
		}
	}

}
