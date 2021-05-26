package src.solutions.google;

/**
 * Implement integer exponentiation. That is, implement the pow(x, y) function,
 * where x and y are integers and returns x^y.
 *
 * Do this faster than the naive method of repeated multiplication.
 *
 * For example, pow(2, 10) should return 1024.
 */

// O(log N) Time complexity
// O(log N) Space complexity
public class _61_Exponentiation {

    private static int getPower(int x, int n) {
        if(n == 0) return 1;
        int temp = getPower(x, n / 2);
        if(n % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }

    public static void main(String[] args) {
        int result = getPower(2,4);
        System.out.println(result);
    }

}
