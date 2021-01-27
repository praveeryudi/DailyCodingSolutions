package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 *
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1]
 */
public class _489_DistinctElements {

    private static int maxLength(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int max = 0;
        int start = 0;
        while(start < nums.length) {
            int end = start;
            while(end < nums.length && !seen.contains(nums[end])) {
                seen.add(nums[end]);
                end++;
            }
            max = Math.max(max, seen.size());
            start++;
            seen.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 5, 2, 3, 4, 1};
        int n = maxLength(nums);
        System.out.println(n);
    }
}
