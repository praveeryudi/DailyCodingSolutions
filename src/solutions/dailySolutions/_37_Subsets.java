package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
 *
 * For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 *
 * You may also use a list or array to represent a set.
 */
public class _37_Subsets {

    private static List<List<Integer>> subsets = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {51, 17945, 27159, 386  };
        helper(nums, 0, new ArrayList<>());
        System.out.println(subsets);
    }

    private static void helper(int[] nums, int index, List<Integer> current) {
        if(!current.isEmpty()) {
            subsets.add(new ArrayList<>(current));
        }
        if(index >= nums.length)
            return;
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
