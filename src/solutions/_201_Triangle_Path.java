package src.solutions;

/**
 * You are given an array of arrays of integers, where each array corresponds to a row in a triangle of numbers.
 * For example, [[1], [2, 3], [1, 5, 1]] represents the triangle:
 * 1 2 3 1 5 1
 * We define a path in the triangle to start at the top and go down one row at a time to an adjacent value,
 * eventually ending with an entry on the bottom row. For example, 1 -> 3 -> 5.
 * The weight of the path is the sum of the entries.
 *
 * Write a program that returns the weight of the maximum weight path.
 */
public class _201_Triangle_Path {

    private static int getMaxWeight(int[][] triangle) {
        int rows = triangle.length;
        int[] dp = new int[1 + rows];

        for(int row = rows - 1; row >= 0; row--) {
            for(int j = 0; j <= row; j++) {
                dp[j] = triangle[row][j] + Math.max(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {1},
                {2,3},
                {1,5,1}
        };
        int max = getMaxWeight(triangle);
        System.out.println("Max Weight = " + max);
    }
}
