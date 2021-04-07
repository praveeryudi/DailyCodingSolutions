package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the palindrome that can be made by inserting the fewest number of characters
 * as possible anywhere in the word.
 * If there is more than one palindrome of minimum length that can be made,
 * return the lexicographically earliest one (the first one alphabetically).
 *
 * For example, given the string "race", you should return "ecarace", since we can add three letters to it
 * (which is the smallest amount to make a palindrome).
 * There are seven other palindromes that can be made from "race" by adding three letters,
 * but "ecarace" comes first alphabetically.
 *
 * As another example, given the string "google", you should return "elgoogle".
 */
public class _34_MinimumInsertPalindrome {

    public static void main(String[] args) {

        String str = "google";
        Map<String, Integer> cache = new HashMap<>();
        int res = helper(str, 0, str.length() - 1, cache);
        System.out.println("Min # of chars to be added: " + res);
        System.out.println(cache);
    }

    private static int helper(String s, int start, int end, Map<String, Integer> cache) {
        if(start >= end)
            return 0;
        String key = start + ":" + end;
        if(cache.containsKey(key))
            return cache.get(key);
        int ans;
        if(s.charAt(start) == s.charAt(end))
            ans = helper(s, start + 1, end - 1, cache);
        else {
            int left = helper(s, start + 1, end, cache);
            int right = helper(s, start, end - 1, cache);
            ans = 1 + Math.min(left, right);
        }
        cache.put(key, ans);
        return ans;
    }

}
