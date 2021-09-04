package solutions.slack;

/**
 * You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?
 *
 * You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.
 *
 * For example, given the following matrix:
 *
 * [[0, 0, 1],
 *  [0, 0, 1],
 *  [1, 0, 0]]
 * Return two, as there are only two ways to get to the bottom right:
 *
 * Right, down, down, right
 * Down, right, down, right
 * The top left corner and bottom right corner will always be 0.
 */
public class _709_WaysInMatrix {

    private static int getWays(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0] == 1 ? 0 : 1;
        for(int c = 1; c < cols; c++) {
            if(matrix[0][c] == 1) {
                dp[0][c] = 0;
            }
            else if(matrix[0][c-1] == 0) {
                dp[0][c] = 1;
            }
            else break;
        }
        for(int r = 1; r < rows; r++) {
            if(matrix[r][0] == 1) {
                dp[r][0] = 0;
            }
            else if(matrix[r-1][0] == 0) {
                dp[r][0] = 1;
            }
            else break;
        }

        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(matrix[r][c] == 0) {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                System.out.print(dp[r][c] + " ");
            }
            System.out.println("");
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1},
                {0,0,1},
                {1,0,0}
        };
        System.out.println(getWays(grid));
    }

}
