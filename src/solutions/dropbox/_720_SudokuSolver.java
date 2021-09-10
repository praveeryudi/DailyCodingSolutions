package solutions.dropbox;

/**
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 *
 * Implement an efficient sudoku solver.
 */
public class _720_SudokuSolver {

    private static boolean solve(char[][] grid, int i, int j) {
        if(i == grid.length) {
            printGrid(grid);
            return true;
        }

        int next_row = 0, next_col = 0;
        if(j == grid.length-1) {
            next_row = i + 1;
            next_col = 0;
        }
        else {
            next_row = i;
            next_col = j + 1;
        }

        if(grid[i][j] != '.') {
            return solve(grid, next_row, next_col);
        }

        // explore the options
        for(int option = 1; option <= 9; option++) {
            if(isValidCell(grid, i, j, option)) {
                grid[i][j] = (char)(option + '0');
                boolean res = solve(grid, next_row, next_col);
                grid[i][j] = '.';
                if(res)
                    return true;
            }
        }
        return false;
    }

    private static boolean isValidCell(char[][] grid, int i, int j, int option) {
        for(int c = 0; c < grid[0].length; c++) {
            if(Character.getNumericValue(grid[i][c]) == option)
                return false;
        }

        for(int r = 0; r < grid.length; r++) {
            if(Character.getNumericValue(grid[r][j]) == option)
                return false;
        }

        int rowStart = 3 * (i/3);
        int colStart = 3 * (j/3);
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(Character.getNumericValue(grid[r + rowStart][c + colStart]) == option)
                    return false;
            }
        }
        return true;
    }

    private static void printGrid(char[][] grid) {
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solve(grid, 0, 0);
    }

}
