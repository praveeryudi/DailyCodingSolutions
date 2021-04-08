package src.solutions.myOwn;

public class _31_EditDistance {

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";

        int rows = 1 + str1.length();
        int cols = 1 + str2.length();

        int[][] dp = new int[rows][cols];
        // First row
        for(int c = 1; c < cols; c++) {
            dp[0][c] = c;
        }
        // First column
        for(int r = 1; r < rows; r++) {
            dp[r][0] = r;
        }

        // Fill the rest
        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(str1.charAt(r-1) == str2.charAt(c-1))
                    dp[r][c] = dp[r-1][c-1];
                else {
                    dp[r][c] = 1 + Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1]));
                }
            }
        }

        System.out.println("Edit distance: " + dp[rows-1][cols-1]);
    }

}
