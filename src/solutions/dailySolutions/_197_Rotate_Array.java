package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an array and a number k that's smaller than the length of the array,
 * rotate the array to the right k elements in-place.
 */
public class _197_Rotate_Array {

    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 1};
        int k = 2;

        // 1. Reverse full array
        reverseArray(arr, 0, arr.length - 1);
        // 2. Reverse first k elements
        reverseArray(arr, 0, k-1);
        // 3. Reverse the remaining elements
        reverseArray(arr, k, arr.length - 1);

        System.out.println("Rotated Array : " + Arrays.toString(arr));
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
