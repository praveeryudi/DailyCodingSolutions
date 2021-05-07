package src.solutions.myOwn;

import java.util.Arrays;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class _21_MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {
                {9,18},
                {11,14},
                {15,17}
        };
        int rooms = getRooms(intervals);
        System.out.println(rooms);
    }

    private static int getRooms(int[][] intervals) {

        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        int idx = 0;
        for(int[] interval : intervals) {
            startTimes[idx] = interval[0];
            endTimes[idx] = interval[1];
            idx++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int i = 0, j = 0;
        int maxRooms = Integer.MIN_VALUE;
        int rooms = 0;

        while(i < n || j < n) {
            if(i >= n) break;
            if(startTimes[i] < endTimes[j]) {
                i++;
                rooms++;
            }
            else {
                j++;
                rooms--;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }

}
