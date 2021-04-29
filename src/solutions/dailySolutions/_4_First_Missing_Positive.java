package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class _4_First_Missing_Positive {

    public static void main(String[] args) {
        int[] arr = {1,2,0};
        int res = getFirstPositive(arr);
        System.out.println(res);
    }

    private static int getFirstPositive(int[] nums) {
        boolean isContainsOne = false;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1)
                isContainsOne = true;
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        System.out.println(Arrays.toString(nums));

        if(!isContainsOne)
            return 1;

        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
