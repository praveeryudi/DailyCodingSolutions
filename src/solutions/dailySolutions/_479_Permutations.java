package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a number in the form of a list of digits, return all possible permutations.
 *
 * For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
 */
public class _479_Permutations {

    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums, 0, nums.length - 1);
        System.out.println(res);
    }

    private static void permute(int[] nums, int start, int end) {
        if(start > end) return;
        if(start == end) {
            res.add(Arrays.toString(nums));
        }
        for(int i = start; i <= end; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
