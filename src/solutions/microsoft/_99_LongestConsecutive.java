package src.solutions.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4].
 * Return its length: 4
 */
public class _99_LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = getLongestConsecutive(nums);
        System.out.println("Max Length: " + res);
    }

    private static int getLongestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int max = 0;
        while(!set.isEmpty()) {
            int x = set.iterator().next();
            set.remove(x);
            int lowerBound = x - 1;
            int upperBound = x + 1;
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

}
