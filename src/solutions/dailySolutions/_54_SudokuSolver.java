package src.solutions.dailySolutions;

/**
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits.
 * The objective is to fill the grid with the constraint that every row, column, and box
 * (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 * <p>
 * Implement an efficient sudoku solver.
 */
public class _54_SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 9, 7, 4, 8, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 2, 4, 0},
                {0, 6, 4, 0, 1, 0, 5, 9, 0},
                {0, 9, 8, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 7, 5, 9, 0, 0}
        };
        solve(board, 0, 0);

        // Print board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean solve(int[][] board, int r, int c) {
        if (r == board.length)
            return true;

        int nextRow;
        int nextCol;
        if (c == board[0].length - 1) {
            nextRow = r + 1;
            nextCol = 0;
        } else {
            nextRow = r;
            nextCol = c + 1;
        }

        if (board[r][c] != 0) {
            return solve(board, nextRow, nextCol);
        }

        // Try all options from 1 to 9 if valid
        for (int option = 1; option <= 9; option++) {
            if (isValid(board, r, c, option)) {
                board[r][c] = option;
                if (solve(board, nextRow, nextCol))
                    return true;
                board[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int r, int c, int option) {
        // check in the same column
        for (int row = 0; row < board.length; row++) {
            if (board[row][c] == option)
                return false;
        }
        // check in same row
        for (int col = 0; col < board[0].length; col++) {
            if (board[r][col] == option)
                return false;
        }

        // check in same grid
        int start_row = 3 * (r / 3);
        int start_col = 3 * (c / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + start_row][j + start_col] == option)
                    return false;
            }
        }
        return true;
    }

}
