package src.solutions.myOwn;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array containing positive and negative numbers, find all the sub arrays in it, whose sum is equal to zero.
 */
public class SumEqualToZero {

    public static void main(String[] args) {
        int[] arr = {-1, 1, 2, -2, 1, -1};

        int k = 1;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for(int i = 1; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum == k) {
                count++;
            }
            else if(map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }
            map.put(currSum, 1 + map.getOrDefault(currSum, 0));
        }
        System.out.println(count);
    }



}
