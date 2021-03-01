package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * Given an unsorted array, in which all elements are distinct, find a "peak" element in O(log N) time.
 * An element is considered a peak if it is greater than both its left and right neighbors.
 * It is guaranteed that the first and last elements are lower than all others.
 */
public class _311_MaxHeap {

    private static void buildHeap(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, i);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void heapify(int[] nums, int index) {
        int largest = index;
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;
        if(leftIndex < nums.length && nums[leftIndex] > nums[largest]) {
            largest = leftIndex;
        }
        if(rightIndex < nums.length && nums[rightIndex] > nums[largest]) {
            largest = rightIndex;
        }
        if(largest != index) {
            swap(nums, largest, index);
            heapify(nums, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,2,11,7,9};
        buildHeap(nums);
    }

}
