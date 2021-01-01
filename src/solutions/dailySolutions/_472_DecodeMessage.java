package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class _472_DecodeMessage {

    private static int decodeHelper(String s, int k, Map<Integer, Integer> cache) {
        if(k == 0)
            return 1;
        if(cache.containsKey(k))
            return cache.get(k);
        int rem = s.length() - k;
        if(s.charAt(rem) == '0')
            return 0;
        int res = decodeHelper(s, k - 1, cache);
        if(k >= 2 && Integer.parseInt(s.substring(rem, rem+2)) <= 26)
            res += decodeHelper(s, k - 2, cache);
        return res;
    }

    private static int getWays(String n) {
        if(null == n)
            return 0;
        return decodeHelper(n, n.length(), new HashMap<>());
    }

    public static void main(String[] args) {
        String str = "261";
        int ways = getWays(str);
        System.out.println("# of ways: " + ways);
    }

}
