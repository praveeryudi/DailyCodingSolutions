package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an array of numbers and a number k,
 * determine if there are three entries in the array which add up to the specified number k.
 * For example, given [20, 303, 3, 4, 25] and k = 49, return true as 20 + 4 + 25 = 49.
 */
public class _518_ThreeSum {

    private static boolean isSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3)
            return false;

        for(int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while(start <= end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == k)
                    return true;
                if(sum < k) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {20, 303, 3, 4, 25};
        int k = 49;
        boolean res = isSum(nums, k);
        System.out.println("Is 3 Sum: " + res);
    }
}
