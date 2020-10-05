package src.solutions.dailySolutions;

import java.util.HashSet;
import java.util.Set;

public class _210_Collatz_Sequence {
    public static void main(String[] args) {
        System.out.println(isCollatzSequence(5, new HashSet<>()));
    }

    private static boolean isCollatzSequence(int N, Set<Integer> cache) {
        if(N == 0)
            return false;

        if(N == 1)
            return true;

        if(cache.contains(N))
            return false;

        boolean res;
        if(N % 2 == 0) {
            res = isCollatzSequence(N/2, cache);
        }
        else {
            res = isCollatzSequence((3 * N) + 1, cache);
        }
        cache.add(N);
        return res;
    }
}
