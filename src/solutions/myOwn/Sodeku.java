package solutions.myOwn;

import java.util.Arrays;

public class Sodeku {

    public static void main(String[] args) {
        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solveSudoku(sudoku);
        System.out.println(Arrays.deepToString(sudoku));
    }

    public static void solveSudoku(int[][] sudoku) {
        // Write your code here.
        backtrack(sudoku, 0, 0);
    }

    private static boolean backtrack(int[][] sudoku, int row, int col) {

        if(row == sudoku.length) {
            return true;
        }

        int next_row;
        int next_col;
        if(col == sudoku[0].length - 1) {
            next_row = row + 1;
            next_col = 0;
        } else {
            next_row = row;
            next_col = col + 1;
        }
        if(sudoku[row][col] != 0) {
            return backtrack(sudoku, next_row, next_col);
        } else {
            for(int option = 1; option <= 9; option++) {
                if(isValid(sudoku, row, col, option)) {
                    sudoku[row][col] = option;
                    boolean res = backtrack(sudoku, next_row, next_col);
                    if(res) return true;
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int row, int col, int option) {
        // Check in row
        for(int c = 0; c < grid[0].length; c++) {
            if(grid[row][c] == option) {
                return false;
            }
        }
        // Check in column
        for(int r = 0; r < grid.length; r++) {
            if(grid[r][col] == option) {
                return false;
            }
        }
        // Check in grid
        int g_start_row = 3 * (row / 3);
        int g_start_col = 3 * (col / 3);
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(grid[r + g_start_row][c + g_start_col] == option) {
                    return false;
                }
            }
        }
        return true;
    }

}
