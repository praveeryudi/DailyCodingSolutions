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
        String data = "111111111111111111111111111111111111111111111";
        int res = getWays(data, data.length(), new HashMap<>());
        System.out.println(res);
    }

    private static int getWays(String data) {
        if(data.startsWith("0")) return 0;
        if(data.isEmpty() || data.length() == 1) return 1;
        int ways = getWays(data.substring(1));
        String first2Chars = data.substring(0, 2);
        if(Integer.valueOf(first2Chars) <= 26) {
            ways += getWays(data.substring(2));
        }
        return ways;
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
