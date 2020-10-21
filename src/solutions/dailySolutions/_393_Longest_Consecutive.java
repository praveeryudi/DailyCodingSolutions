package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an array of integers, return the largest range, inclusive,
 * of integers that are all included in the array.
 *
 * For example, given the array [9, 6, 1, 3, 8, 10, 12, 11], return (8, 12)
 * since 8, 9, 10, 11, and 12 are all in the array.
 */
public class _393_Longest_Consecutive {

    private static int getLongestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int max = 0;
        Iterator<Integer> itr = set.iterator();
        while(!set.isEmpty()) {
            int x = itr.next();
            itr.remove();

            int lowerBound = x - 1;
            int upperBound = x + 1;
            while(set.contains(lowerBound)) {
                lowerBound -= 1;
            }
            while(set.contains(upperBound)) {
                upperBound += 1;
            }

            if(upperBound - lowerBound - 1 > max) {
                max = upperBound - lowerBound - 1;
                System.out.println("Interval " + (lowerBound + 1) + "-" + (upperBound - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,1,3,8,10,12,11};
        int res = getLongestConsecutive(nums);
        System.out.println(res);
    }
}
