package src.solutions.dailySolutions;

/**
 * A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.
 *
 * Given N, write a function to return the number of knight's tours on an N by N chessboard.
 */
public class _64_KnightsTour {

    public static void main(String[] args) {
        int n = 3;
        int[][] board = new int[n][n];
        dfs(board, 0, 0, 1);
    }

    private static void dfs(int[][] board, int r, int c, int move) {
        // check within bounds
        if(r < 0 || c < 0 || r >= board.length || c >= board.length)
            return;
        // check if already visited
        if(board[r][c] != 0)
            return;
        // check if move becomes equal to number of squares
        if(move == board.length * board.length) {
            board[r][c] = move;
            printBoard(board);
            System.out.println("");
            board[r][c] = 0;
            return;
        }

        board[r][c] = move;
        dfs(board, r-2, c+1, move+1);
        dfs(board, r-1, c+2, move+1);
        dfs(board, r+1, c+2, move+1);
        dfs(board, r+2, c+1, move+1);
        dfs(board, r+2, c-1, move+1);
        dfs(board, r+1, c-2, move+1);
        dfs(board, r-1, c-2, move+1);
        dfs(board, r-2, c-1, move+1);
        board[r][c] = 0;
    }

    private static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
