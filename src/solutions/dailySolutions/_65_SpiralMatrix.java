package src.solutions.dailySolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _65_SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] nums = new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
		//printSpiralMatrix(nums);
		
		int[][] ret = generateMatrix(3);
		for(int i =0; i < ret.length; i++) {
			for(int j =0; j<ret[0].length; j++) {
				System.out.print(ret[i][j] + " ");
			}
		}

	}
	
	private static void printSpiralMatrix(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int rowBegin = 0, colBegin = 0;
		int rowEnd = rows - 1, colEnd = cols - 1;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd) {
			for(int i = colBegin; i <= colEnd; i++) {
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			
			for(int i = rowBegin; i <= rowEnd; i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			if(rowBegin <= rowEnd) {
				for(int i = colEnd; i >= colBegin; i--) {
					res.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			
			if(colBegin <= colEnd) {
				for(int i = rowEnd; i >= rowBegin; i--) {
					res.add(matrix[i][colBegin]);
				}
				colBegin++;
			}
			
		}
		System.out.println(res.toString());
	}
	
	private static int[][] generateMatrix(int n) {
        
        int matrix[][] = new int[n][n];
        
        int idx = 1;
        
        int rowBegin = 0, rowEnd = n-1;
        int colBegin = 0, colEnd = n-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int i = colBegin; i <= colEnd; i++){
                matrix[rowBegin][i] = idx++;
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = idx++;
            }
            colEnd--;
            
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = idx++;
                }
                rowEnd--;
            }
            
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = idx++;
                }
                colBegin++;
            }
                
        }
        return matrix;
    }

}
