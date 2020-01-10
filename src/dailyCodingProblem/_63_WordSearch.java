package dailyCodingProblem;

public class _63_WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = new char[][] {
			{'F', 'A', 'C', 'I'},
			{'O', 'B', 'Q', 'P'},
			{'A', 'N', 'O', 'B'},
			{'M', 'A', 'S', 'S'}
		};
		String str = "CQOB";
		System.out.println(isWordFound(matrix, str));
	}
	
	private static boolean isWordFound(char[][] matrix, String word) {
		if(null == matrix || matrix.length == 0)
			return false;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == word.charAt(0) && dfs(matrix, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean dfs(char[][] matrix, int i, int j, int count, String word) {
		if(count == word.length())
			return true;
		
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word.charAt(count))
			return false;
		
		boolean isFound = dfs(matrix, i + 1, j, count + 1, word) || dfs(matrix, i, j + 1, count + 1, word);
		return isFound;
	}

}
