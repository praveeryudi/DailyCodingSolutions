package solutions;

/**
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 *
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10},
 * it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
 *
 * Given the multiset {15, 5, 20, 10, 35}, it would return false,
 * since we can't split it up into two subsets that add up to the same sum.
 */

public class _60_Equal_Subset {

    public static void main(String[] args) {
        int[] nums = {15,5,20,10,35};
        boolean res = canPartition(nums);
        System.out.println(res);
    }

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        return canPartition(nums, 0, sum / 2);
    }

    private static boolean canPartition(int[] nums, int index, int sum) {
        if(sum == 0)
            return true;
        if(index >= nums.length)
            return false;
        boolean include = canPartition(nums, index + 1, sum - nums[index]);
        boolean exclude = canPartition(nums, index + 1, sum);
        return include || exclude;
    }

}
