package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

public class _298_Collect_Apples {

    private static int longestSequence(int[] arr) {

        Map<Integer, Integer> counts = new HashMap<>();
        int start = 0;
        int end = arr.length - 1;
        int maxLength = Integer.MIN_VALUE;

        while(start <= end) {
            for(int i = start; i < arr.length; i++) {
                if(counts.containsKey(arr[i])) {
                    counts.put(arr[i], 1 + counts.get(arr[i]));
                }
                else if(counts.size() == 2) {
                    int sum = counts.values().stream().reduce(0, Integer::sum);
                    maxLength = Math.max(maxLength, sum);
                    counts.clear();
                    break;
                }
                else {
                    counts.put(arr[i], 1);
                }
            }
            start++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = {2,1,2,3,3,1,3,5};
        int res = longestSequence(input);
        System.out.println("Longest Path = " + res);
    }

}
