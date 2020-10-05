package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

public class _7_DecodeWays {
	
	
	private static int decodeWays(String data, int k, Map<Integer,Integer> cache) {
		if(k == 0)
			return 1;
		int index = data.length() - k;
		if(data.charAt(index) == '0')
			return 0;
		
		if(cache.containsKey(k))
			return cache.get(k);
		
		int result = decodeWays(data, k-1, cache);
		if(k >= 2 && Integer.parseInt(data.substring(index, index+2)) <= 26)
			result += decodeWays(data, k-2, cache);
		cache.put(k, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String encodedString = "111";
		int ways = decodeWays(encodedString, encodedString.length(), new HashMap<Integer, Integer>());
		System.out.println("# of ways to decode = " + ways);
		
	}

}
