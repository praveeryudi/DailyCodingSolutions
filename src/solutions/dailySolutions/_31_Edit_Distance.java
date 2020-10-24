package solutions.dailySolutions;

/**
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other.
 * For example, the edit distance between “kitten” and “sitting” is three:
 * substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 *
 * Given two strings, compute the edit distance between them.
 */
public class _31_Edit_Distance {

    public static void main(String[] args) {
        int res = getEditDistance("sitting", "kitten");
        System.out.println("Edit Distance = " + res);
    }

    private static int getEditDistance(String s1, String s2) {
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 0;

        for(int r = 1; r < rows; r++) {
            dp[r][0] = 1;
        }
        for(int c = 1; c < cols; c++) {
            dp[0][c] = 1;
        }

        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(s1.charAt(r-1) == s2.charAt(c-1)) {
                    dp[r][c] = dp[r-1][c-1];
                }
                else {
                    dp[r][c] = 1 + Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c]));
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}
