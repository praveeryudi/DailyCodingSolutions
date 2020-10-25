package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of numbers, find the length of the longest increasing sub sequence in the array.
 * The sub sequence does not necessarily have to be contiguous.
 *
 * For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15],
 * the longest increasing sub sequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class _75_LIS {

    public static void main(String[] args) {
        int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result = lisHelper(nums, -1, 0, new HashMap<>());
        System.out.println(result);
    }

    private static int lisHelper(int[] nums, int prev, int curr, Map<String, Integer> cache) {
        if(curr == nums.length)
            return 0;

        String key = prev + ":" + curr;
        if(cache.containsKey(key))
            return cache.get(key);

        int res1 = 0;
        if(prev == -1 || nums[curr] > nums[prev]) {
            res1 = 1 + lisHelper(nums, curr, curr + 1, cache);
        }
        int res2 = lisHelper(nums, prev, curr + 1, cache);
        int res = Math.max(res1, res2);
        cache.put(key, res);
        return res;
    }
}
