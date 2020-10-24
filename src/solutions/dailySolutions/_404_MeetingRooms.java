package solutions.dailySolutions;

import java.util.Arrays;

public class _404_MeetingRooms {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] lectures = {
                {30,75},
                {0,50},
                {60,150}
        };

        int res = getRooms(lectures);
        System.out.println("# of rooms :: " + res);

    }

    private static int getRooms(int[][] times) {
        int n = times.length;
        int[] startTimes = new int[n];
        int idx = 0;
        for(int[] time : times) {
            startTimes[idx++] = time[0];
        }

        int[] endTimes = new int[n];
        idx = 0;
        for(int[] time : times) {
            endTimes[idx++] = time[1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int stIdx = 0, endIdx = 0;
        int max = 0, curr = 0;
        while(stIdx < startTimes.length || endIdx < endTimes.length) {
            if(stIdx >= startTimes.length)
                break;
            if(startTimes[stIdx] < endTimes[endIdx]) {
                curr++;
                stIdx++;
            }
            else {
                curr--;
                endIdx++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

}

