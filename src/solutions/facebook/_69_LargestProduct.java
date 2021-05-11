package src.solutions.facebook;

import java.util.Arrays;

/**
 * Given a list of integers, return the largest product that can be made by multiplying any three integers.
 * For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
 * You can assume the list has at least three integers.
 */
public class _69_LargestProduct {

    public static void main(String[] args) {
        int[] nums = {-10, -10, 5, 2};
        int output = largestProduct(nums);
        System.out.println("Largest Product: " + output);
    }

    private static int largestProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1] * nums[n-2] * nums[n-3], nums[0] * nums[1] * nums[n-1]);
    }

}
