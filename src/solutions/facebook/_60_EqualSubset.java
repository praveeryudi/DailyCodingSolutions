package src.solutions.facebook;

/**
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 *
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
 *
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
 */
public class _60_EqualSubset {

    public static void main(String[] args) {
        int[] nums = {15, 5, 20, 10, 35};
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        boolean res = false;
        if(sum % 2 != 0)
            System.out.println("Sum odd, can't partition");
        else
        {
            res = canPartition(nums, nums.length - 1, sum / 2);
        }
        System.out.println("Can Partition: " + res);
    }

    private static boolean canPartition(int[] nums, int index, int sum) {
        if(index < 0 || sum < 0)
            return false;
        if(sum == 0)
            return true;
        boolean isInclude = canPartition(nums, index - 1, sum - nums[index]);
        boolean isExclude = canPartition(nums, index - 1, sum);
        return isInclude || isExclude;
    }

}
