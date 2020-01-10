package dailyCodingProblem;

import java.util.Arrays;
import java.util.List;

public class _98_WordSearch {

	public static void main(String[] args) {
		
		List<String> A = Arrays.asList("FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF");
		int rows = A.size();
        int cols = A.get(0).trim().length();
        
        char[][] arr = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = A.get(i).charAt(j);
            }
        }
        
        // Print
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        
		
		/*char[][] arr = new char[][] {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};*/
		
		String input = "BCDCB";
		System.out.println("Is Word Exists = " + isWordPresent(arr, input));
	}
	
	private static boolean isWordPresent(char[][] arr, String word) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == word.charAt(0) && isExists(arr, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isExists(char[][] matrix, int r, int c, int count, String word) {
		if(count == word.length())
			return true;
		
		if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] != word.charAt(count))
			return false;
		
		char temp = matrix[r][c];
		matrix[r][c] = '\0';
		
		boolean isFound = isExists(matrix, r - 1, c, count + 1, word) ||
				isExists(matrix, r + 1, c, count + 1, word) ||
				isExists(matrix, r, c - 1, count + 1, word) ||
				isExists(matrix, r, c + 1, count + 1, word);
		
		matrix[r][c] = temp;
		return isFound;
	}

}
