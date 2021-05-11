package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an array of integers, determine whether it contains a Pythagorean triplet.
 * Recall that a Pythogorean triplet (a, b, c) is defined by the equation a2+ b2= c2.
 */
public class _282_PythagoreanTriplet {

    public static void main(String[] args) {
        int[] nums = {10, 4, 6, 12, 5};
        boolean isPresent = isPythagoreanTriplet(nums);
        System.out.println("Is Triplet Present = " + isPresent);
    }

    private static boolean isPythagoreanTriplet(int[] nums) {
        int n = nums.length;
        //1. Square the elements [O(n)]
        for(int index = 0; index < n; index++) {
            nums[index] = nums[index] * nums[index];
        }

        //2. Sort the array [O(nLogn)]
        Arrays.sort(nums);

        //3. Fix the last element
        for(int i = n-1; i >= 0; i--) {
            int left = 0;
            int right = i-1;

            while(left <= right) {
                int a = nums[left];
                int b = nums[right];
                int c = nums[i];
                if((a + b) == c) {
                    return true;
                }

                if((a + b) < c) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return false;
    }

}
