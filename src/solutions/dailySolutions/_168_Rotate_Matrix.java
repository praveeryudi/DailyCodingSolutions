package src.solutions.dailySolutions;

public class _168_Rotate_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		// Transpose the matrix
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// Swap the row elements
		int cols = matrix[0].length;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j <= cols/ 2; j++) {
				int temp = matrix[i][cols-j-1];
				matrix[i][cols-j-1] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
		// Print the rotated matrix
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
