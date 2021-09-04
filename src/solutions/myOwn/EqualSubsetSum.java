package solutions.myOwn;

import java.util.Arrays;

public class EqualSubsetSum {

    public static void main(String[] args) {

        int[] nums = {-5,-5,-2,-2};
        System.out.println("Can Partition :: " + isPartitionPossible(nums));
    }

    private static boolean isPartitionPossible(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;

        Arrays.sort(nums);
        return combinationSum(nums, nums.length - 1, sum / 2);
    }

    private static boolean combinationSum(int[] nums, int index, int remSum) {
        if(remSum == 0) {
            return true;
        }
        if(index < 0 || remSum < 0)
            return false;

        // Case 1. Include the current element: sum left changes
        boolean includeItem = combinationSum(nums, index - 1, remSum - nums[index]);
        // Case 2. Exclude the current element: sum remains same
        boolean excludeItem = combinationSum(nums, index - 1, remSum);
        return includeItem || excludeItem;
    }
}
