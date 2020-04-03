package src.solutions;

public class _122_Maximum_Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
				{0,3,1,1},
				{2,0,0,4},
				{1,5,3,1}
		};
		System.out.println("Max Coins = " + getMaximumCoins(matrix));
	}
	
	private static int getMaximumCoins(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		// Set first row
		for(int index = 1; index < cols; index++) {
			matrix[0][index] += matrix[0][index-1]; 
		}
		
		// Set first column
		for(int index = 1; index < rows; index++) {
			matrix[index][0] += matrix[index-1][0]; 
		}
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				matrix[i][j] += Math.max(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		return matrix[rows-1][cols-1];
	}

}
