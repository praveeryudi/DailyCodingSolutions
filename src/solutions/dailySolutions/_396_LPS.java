package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, return the length of the longest palindromic subsequence in the string.
 *
 * For example, given the following string:
 * MAPTPTMTPA
 * Return 7, since the longest palindromic subsequence in the string is APTMTPA.
 * Recall that a subsequence of a string does not have to be contiguous!
 */
public class _396_LPS {

    private static int lps(String input, int start, int end, Map<String, Integer> cache) {
        if(start > end)
            return 0;

        if(start == end)
            return 1;

        String key = start + ":" + end;
        if(cache.containsKey(key))
            return cache.get(key);

        int res;
        if(input.charAt(start) == input.charAt(end)) {
            res = 2 + lps(input, start + 1, end - 1, cache);
        }
        else {
            int lps1 = lps(input, start + 1, end, cache);
            int lps2 = lps(input, start, end - 1, cache);
            res = Math.max(lps1, lps2);
        }
        cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String str = "MAPTPTMTPA";
        int output = lps(str, 0, str.length() - 1, new HashMap<>());
        System.out.println(output);
    }

}
