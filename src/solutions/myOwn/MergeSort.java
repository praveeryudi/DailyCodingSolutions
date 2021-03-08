package src.solutions.myOwn;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {10,12,14,21,2,4,7,10,7,8,11,12};
        mergeSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] first = new int[mid];
        int[] second = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            first[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            second[i - mid] = a[i];
        }
        mergeSort(first, mid);
        mergeSort(second, n - mid);

        merge(a, first, second);
    }

    private static void merge(int[] nums, int[] first, int[] second) {

        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                nums[k++] = first[i++];
            }
            else {
                nums[k++] = second[j++];
            }
        }
        while (i < first.length) {
            nums[k++] = first[i++];
        }
        while (j < second.length) {
            nums[k++] = second[j++];
        }
    }

}
