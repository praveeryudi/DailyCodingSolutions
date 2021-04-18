package src.solutions.dailySolutions;

import java.util.Arrays;

/**
 * We can determine how "out of order" an array A is by counting the number of inversions it has.
 * Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j.
 * That is, a smaller element appears after a larger element.
 *
 * Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 *
 * You may assume each element in the array is distinct.
 *
 * For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3).
 * The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */
public class _44_ArrayInversions {

    public static void main(String[] args) {
        int[] nums = {2,4,1,3,5};
        int inversions = mergeAndCount(nums, 0, nums.length - 1);
        System.out.println("Total Inversions: " + inversions);
        System.out.println(Arrays.toString(nums));
    }

    private static int mergeAndCount(int[] nums, int l, int r) {
        int count = 0;
        if(l < r) {
            int mid = (l + r) / 2;
            count += mergeAndCount(nums, l, mid);
            count += mergeAndCount(nums, mid + 1, r);
            count += merge(nums, l, mid, r);
        }
        return count;
    }

    private static int merge(int[] nums, int l, int mid, int r) {
        int[] leftArr = Arrays.copyOfRange(nums, l, mid + 1);
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, r + 1);
        int i = 0, j = 0, k = l;
        int swaps = 0;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            }
            else {
                nums[k] = rightArr[j];
                j++;
                swaps += (mid + 1) - (l + i);
                System.out.println("# of swaps: " + swaps);
            }
            k++;
        }

        while(i < leftArr.length) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArr.length) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
        return swaps;
    }

}
