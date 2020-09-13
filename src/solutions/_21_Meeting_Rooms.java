package solutions;

import java.util.Arrays;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class _21_Meeting_Rooms {

    private static int getMinRooms(int[][] times) {
        int n = times.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];

        int idx = 0;
        for(int[] arr : times) {
            startTime[idx] = arr[0];
            endTime[idx] = arr[1];
            idx++;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i = 0, j = 0;
        int rooms = 0;
        int maxRooms = 0;
        while(i < startTime.length || j < endTime.length) {
            if(i >= startTime.length)
                break;
            if(startTime[i] < endTime[j]) {
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

    public static void main(String[] args) {
        int[][] lectures = {
                {30,75},
                {0,50},
                {60,150}
        };
        int result = getMinRooms(lectures);
        System.out.println("Min Rooms = " + result);
    }
}
