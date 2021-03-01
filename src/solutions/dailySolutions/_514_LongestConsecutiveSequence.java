package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class _514_LongestConsecutiveSequence {

    private static int longestConsecutiveSequence(int[] nums) {
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            int lowerBound = num, upperBound = num;
            while(set.contains(lowerBound)) {
                lowerBound--;
            }
            while(set.contains(upperBound)) {
                upperBound++;
            }

            int len = upperBound - lowerBound - 1;
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutiveSequence(nums);
        System.out.println(res);
    }

}
