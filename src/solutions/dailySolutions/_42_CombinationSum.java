package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
 * If such a subset cannot be made, then return null.
 * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */
public class _42_CombinationSum {

	private static List<List<Integer>> getAllCombinations(int[] nums, int k) {
		List<List<Integer>> results = new ArrayList();
		if (null == nums || nums.length == 0)
			return results;

		Arrays.sort(nums);
		List<Integer> combination = new ArrayList<Integer>();
		helper(nums, combination, results, k, 0);
		return results;
	}

	private static void helper(int[] nums, List<Integer> combination, List<List<Integer>> results, int remTarget,
			int startIndex) {
		if (remTarget == 0) {
			results.add(new ArrayList<Integer>(combination));
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if(nums[i] > remTarget) 
				break;
			combination.add(nums[i]);
			helper(nums, combination, results, remTarget - nums[i], i);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		
		int[] input = new int[] {2, 7, 6, 3};
		List<List<Integer>> combinationList = getAllCombinations(input, 7);
		System.out.println(combinationList.toString());
	}

}
