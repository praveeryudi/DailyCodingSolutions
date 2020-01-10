package dailyCodingProblem;

public class _84_NumberOfIslands {

	public static void main(String[] args) {
		
		int[][] input = new int[][] {{1,0,0,0,0}, {0,0,1,1,0}, {0,1,1,0,0}, {0,0,0,0,0}, {1,1,0,0,1}, {1,1,0,0,1}};
		int rows = input.length;
		int cols = input[0].length;
		int islands = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(input[i][j] == 1) {
					islands += getIslandsDFS(input, i, j);
				}
			}
		}
		System.out.println("Number of Islands :: " + islands);
	}
	
	private static int getIslandsDFS(int[][] matrix, int i, int j) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0)
			return 0;
		
		matrix[i][j] = 0;
		getIslandsDFS(matrix, i - 1, j);
		getIslandsDFS(matrix, i + 1, j);
		getIslandsDFS(matrix, i, j - 1);
		getIslandsDFS(matrix, i, j + 1);
		
		return 1;
	}

}
