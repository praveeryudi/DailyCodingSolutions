package src.solutions.dailySolutions;

/**
 * You have an N by N board. Write a function that, given N,
 * returns the number of possible arrangements of the board where N queens can be placed
 * on the board without threatening each other,
 * i.e. no two queens share the same row, column, or diagonal.
 */
public class _38_NQueens {

    private static int arrangements = 0;

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        placeNQueens(board, 0);
        System.out.println("# of arrangements: " + arrangements);
    }

    private static void placeNQueens(int[][] board, int row) {
        if(row == board.length) {
            arrangements += 1;
            return;
        }
        for(int c = 0; c < board.length; c++) {
            if(isSafe(board, row, c)) {
                board[row][c] = 1;
                placeNQueens(board, row + 1);
                board[row][c] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        // check in same column upwards
        int r = row - 1;
        while(r >= 0) {
            if(board[r][col] == 1)
                return false;
            r--;
        }

        // check in upper left diagonal
        r = row - 1;
        int c = col-1;
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 1)
                return false;
            r--;
            c--;
        }

        // check in upper right diagonal
        r = row - 1;
        c = col + 1;
        while(r >= 0 && c < board.length) {
            if(board[r][c] == 1)
                return false;
            r--;
            c++;
        }
        return true;
    }
}
