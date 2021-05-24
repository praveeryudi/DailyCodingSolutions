package src.solutions.amazon;

/**
 * An sorted array of integers was rotated an unknown number of times.
 *
 * Given such an array, find the index of the element in the array in faster than linear time.
 * If the element doesn't exist in the array, return null.
 *
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 *
 * You can assume all the integers in the array are unique.
 */
public class _58_SearchInRotatedArray {

    private static int findIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;

            // If LHS is sorted
            if(nums[start] < nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            // If RHS is sorted
            else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {13, 18, 25, 2, 8, 10};
        int index = findIndex(nums, 8);
        System.out.println("Number found at index: " + index);
    }

}
