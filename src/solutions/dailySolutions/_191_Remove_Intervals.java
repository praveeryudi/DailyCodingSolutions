package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals,
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Intervals can "touch", such as [0, 1] and [1, 2], but they won't be considered overlapping.
 *
 * For example, given the intervals (7, 9), (2, 4), (5, 8),
 * return 1 as the last interval can be removed and the first two won't overlap.
 *
 * The intervals are not necessarily sorted in any order.
 */
public class _191_Remove_Intervals {

    private static List<int[]> removeInterval(List<int[]> intervals) {
        List<int[]> res = new ArrayList<>();
        intervals.sort((a, b) -> a[0] - b[0]);

        int[] prev = intervals.get(0);
        for(int index = 1; index < intervals.size(); index++) {
            int[] currInterval = intervals.get(index);
            if(currInterval[0] > prev[1]) {
                if(!res.contains(prev))
                    res.add(prev);
                res.add(currInterval);
            }
            else {

                int start = Math.min(currInterval[0], prev[0]);
                int end = Math.max(currInterval[1], prev[1]);
                int[] newInterval = new int[] {start, end};
                intervals.remove(index);
                intervals.add(index, newInterval);
            }
            prev = intervals.get(index);
        }

        if(res.isEmpty())
            res.add(prev);
        return res;
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{7,9});
        input.add(new int[]{2,4});
        input.add(new int[]{5,8});
        List<int[]> result = removeInterval(input);
        for(int[] arr : result)
            System.out.println(Arrays.toString(arr));
    }

}
