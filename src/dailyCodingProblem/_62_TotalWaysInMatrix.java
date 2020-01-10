package dailyCodingProblem;

public class _62_TotalWaysInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = new int[][] {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] solMatrix = new int[rows][cols];
		
		// Populate the first row
		for(int col = 0; col < cols; col++) {
			solMatrix[0][col] = 1;
		}
		// Populate the first column
		for(int row = 0; row < rows; row++) {
			solMatrix[row][0] = 1;
		}
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				solMatrix[i][j] = solMatrix[i][j - 1] + solMatrix[i - 1][j];
			}
		}

		int result = solMatrix[rows-1][cols - 1];
		System.out.println("Total Number of Ways :: " + result);
	}
}
