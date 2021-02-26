package src.solutions.myOwn;

import java.util.Arrays;

public class MinHeap {

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void heapify(int[] nums, int index) {

        int smallest = index;
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        if(leftChild < nums.length && nums[leftChild] < nums[smallest])
            smallest = leftChild;
        if(rightChild < nums.length && nums[rightChild] < nums[smallest])
            smallest = rightChild;

        if(smallest != index)
        {
            swap(nums, smallest, index);
            heapify(nums, smallest);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 6, 8, 9, 7, 3, 1};
        int n = nums.length;
        for(int i = n-1; i >= 0; i--) {
            heapify(nums, i);
        }

        System.out.println(Arrays.toString(nums));
    }
}
