package src.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the smallest window that contains every distinct character.
 * Characters may appear more than once in the window.
 *
 * For example, given "jiujitsu", you should return 5, corresponding to the final five letters.
 */
public class _320_MinWindow {

    public static void main(String[] args) {
        String input = "jiujitsu";
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;

        while(right < input.length()) {
            for(char ch : input.toCharArray()) {
                seen.add(ch);
            }

            while(right < input.length() && !seen.isEmpty()) {
                seen.remove(input.charAt(right));
                right++;
            }

            if(seen.isEmpty()) {
                System.out.println("All char string = " + input.substring(left, right));
                right--;
                minLength = Math.min(minLength, right - left + 1);
                left++;
                right = left;
            }
            else break;
        }
        System.out.println("Min Length = " + minLength);
    }

}
