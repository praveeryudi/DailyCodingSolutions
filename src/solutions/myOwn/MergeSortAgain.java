package solutions.myOwn;

import java.util.Arrays;

public class MergeSortAgain {

    public static void main(String[] args) {
        int[] nums = {5,3,7,1};
        doMergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void doMergeSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            doMergeSort(nums, low, mid);
            doMergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k += 1; i += 1;
            } else {
                temp[k] = nums[j];
                k += 1; j += 1;
            }
        }

        while (i <= mid) {
            temp[k] = nums[i];
            k += 1; i += 1;
        }

        while (j <= end) {
            temp[k] = nums[j];
            k += 1; j += 1;
        }

        for (i = start; i <= end; i += 1) {
            nums[i] = temp[i - start];
        }
    }

}
