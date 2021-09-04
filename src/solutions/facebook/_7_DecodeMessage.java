package src.solutions.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class _7_DecodeMessage {

    public static void main(String[] args) {
        String data = "1411511110191111101011871111111111111511374411510811111311124711511116468111611111116111111111117";
        int res = getWays(data, data.length(), new HashMap<>());
        System.out.println(res);
    }

    // k denotes the last 'k' characters
    private static int getWays(String data, int k, Map<Integer, Integer> cache) {

        if(k == 0) return 1;

        if(cache.containsKey(k))
            return cache.get(k);

        int firstCharIndex = data.length() - k;
        if(data.charAt(firstCharIndex) == '0')
            return 0;

        int ways = getWays(data, k-1, cache);
        if(k >= 2) {
            String first2Chars = data.substring(firstCharIndex, firstCharIndex + 2);
            if(Integer.valueOf(first2Chars) <= 26) {
                ways += getWays(data, k-2, cache);
            }
        }
        cache.put(k, ways);
        return ways;
    }

}
