package dailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class _12_ClimbingStaircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int steps = 4;
		System.out.println("# of ways - " + getWays(steps, new HashMap<Integer, Integer>()));

	}
	
	private static int getWays(int n, Map<Integer, Integer> cache) {
		if(n == 0 || n == 1)
			return 1;
		
		if(cache.containsKey(n))
			return cache.get(n);
		
		int ways = getWays(n - 1, cache) + getWays(n - 2, cache);
		cache.put(n, ways);
		return ways;
	}

}
