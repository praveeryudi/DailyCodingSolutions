package solutions.stripe;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class _694_FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(getFirstMissingPositive(nums));
    }

    private static int getFirstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean isOne = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                isOne = true;
            }
            if(nums[i] > n || nums[i] <= 0)
                nums[i] = 1;
        }
        System.out.println(Arrays.toString(nums));

        if(!isOne)
            return 1;

        for(int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx] =-nums[idx];
        }
        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        System.out.println(Arrays.toString(nums));
        return n+1;

    }

}
