package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of possibly overlapping intervals,
 * return a new list of intervals where all overlapping intervals have been merged.
 *
 * The input list is not necessarily ordered in any way.
 *
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 */
public class _77_Merge_Intervals {

    private static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {5,8},
                {4,10},
                {20,25}
        };
        List<Interval> output = mergeIntervals(intervals);
        System.out.println(output);
    }

    private static List<Interval> mergeIntervals(int[][] intervals) {
        List<Interval> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        for(int[] curr : intervals) {
            if(res.isEmpty()) {
                res.add(new Interval(curr[0], curr[1]));
                continue;
            }
            Interval prev = res.get(res.size() - 1);
            if(prev.end < curr[0])
                res.add(new Interval(curr[0], curr[1]));
            else
                prev.end = Math.max(prev.end, curr[1]);
        }
        return res;
    }

}
