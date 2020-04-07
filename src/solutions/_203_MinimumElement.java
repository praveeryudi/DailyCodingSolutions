package solutions;

public class _203_MinimumElement {

    private static int getMinimum(int[] nums, int low, int high) {
        if(low > high) return nums[0];
        if(low == high) return nums[low];

        int mid = (low + high)/ 2;

        // case (3,4,5,1,2)
        if(mid < high && nums[mid] > nums[mid + 1])
            return nums[mid + 1];

        // case (8,6,5,3,4)
        if(mid > low && nums[mid] < nums[mid-1])
            return nums[mid];

        if(nums[mid] > nums[low]) {
            return getMinimum(nums, mid + 1, high);
        }
        else {
            return getMinimum(nums, low, mid - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {5, 7, 10, 3, 4};
        int min = getMinimum(arr, 0, arr.length - 1);
        System.out.println("Minimum = " + min);
    }


}
