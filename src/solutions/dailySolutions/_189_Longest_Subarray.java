package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1],
 * return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
 */
public class _189_Longest_Subarray {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 5, 2, 3, 4, 1};
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        Set<Integer> seen = new HashSet<>();

        while(start < arr.length) {
            for(int i = start; i < arr.length; i++) {
                if(seen.contains(arr[i])) {
                    maxLength = Math.max(maxLength, seen.size());
                    start++;
                    seen.clear();
                    break;
                }
                else {
                    seen.add(arr[i]);
                }
            }
        }

        System.out.println("Max length of distinct elements = " + maxLength);
    }

}
