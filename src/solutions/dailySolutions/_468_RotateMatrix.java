package src.solutions.dailySolutions;

/**
 * Given an N by N matrix, rotate it by 90 degrees clockwise.
 */
public class _468_RotateMatrix {

    private static void rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < rows; i++) {
            int start = 0, end = cols - 1;
            while(start <= end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        // Print
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrix(matrix);
    }

}
