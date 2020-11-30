package src.solutions.dailySolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string and a set of characters, return the shortest substring containing all the characters in the set.
 *
 * For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".
 *
 * If there is no substring containing all the characters in the set, return null.
 */
public class _437_ShortestSubstring_All_Chars {

    private static String getShortest(String input, List<Character> list) {
        int start = 0;
        Set<Character> chars = new HashSet<>();
        int minLength = Integer.MAX_VALUE;
        String output = "";
        while(start < input.length()) {
            chars.addAll(list);
            int end = start;
            while(end < input.length() && !chars.isEmpty()) {
                chars.remove(input.charAt(end));
                end++;
            }
            if(chars.isEmpty()) {
                int curr = end - start;
                if(curr < minLength) {
                    minLength = curr;
                    output = input.substring(start, end);
                }
            }
            start++;
            chars.clear();
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "figehaeci";
        String res = getShortest(str, Arrays.asList('a', 'e', 'i'));
        System.out.println(res);
    }

}
