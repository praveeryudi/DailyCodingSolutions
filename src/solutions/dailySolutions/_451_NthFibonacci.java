package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the function fib(n), which returns the nth number in the Fibonacci sequence,
 * using only O(1) space.
 */
public class _451_NthFibonacci {

    private static int fib(int n, Map<Integer, Integer> cache) {
        if(n == 1 || n == 2)
            return 1;
        if(cache.containsKey(n))
            return cache.get(n);
        int num = fib(n-2, cache) + fib(n-1, cache);
        cache.put(n, num);
        return num;
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(fib(N, new HashMap<>()));
    }

}
