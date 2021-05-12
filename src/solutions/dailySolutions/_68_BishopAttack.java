package src.solutions.dailySolutions;

/**
 * On our special chessboard, two bishops attack each other if they share the same diagonal.
 * This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
 *
 * You are given N bishops, represented as (row, column) tuples on a M by M chessboard.
 * Write a function to count the number of pairs of bishops that attack each other.
 * The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).
 *
 * For example, given M = 5 and the list of bishops:
 *
 * (0, 0)
 * (1, 2)
 * (2, 2)
 * (4, 0)
 * The board would look like this:
 *
 * [b 0 0 0 0]
 * [0 0 b 0 0]
 * [0 0 b 0 0]
 * [0 0 0 0 0]
 * [b 0 0 0 0]
 * You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.
 */
public class _68_BishopAttack {

    public static void main(String[] args) {
        char[][] board = {
                {'b', '0', '0', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'b', '0', '0', '0', '0'}
        };
        int[][] positions = {
                {0, 0}, {1, 2}, {2, 2}, {4, 0}
        };
        int result = getTotalAttacks(board, positions, 5);
        System.out.println(result);
    }

    private static int getTotalAttacks(char[][] board, int[][] positions, int M) {

        boolean[][] visited = new boolean[M][M];
        int totalAttacks = 0;
        // Process every bishop position
        for(int[] position : positions) {
            int x = position[0];
            int y = position[1];
            totalAttacks += findTopLeft(board, x, y, visited, M) +
                    findTopRight(board, x, y, visited, M) +
                    findBottomLeft(board, x, y, visited, M) +
                    findBottomRight(board, x, y, visited, M);
        }
        return totalAttacks;
    }

    private static int findTopLeft(char[][] board, int x, int y, boolean[][] visited, int m) {
        int attacks = -1; // -1 as the current bishop will NOT attack itself
        while(x >= 0 && y >= 0 && x < m && y < m && !visited[x][y]) {
            if(board[x][y] == 'b')
                attacks++;
            else
                visited[x][y] = true;
            x--;
            y--;
        }
        return attacks;
    }

    private static int findTopRight(char[][] board, int x, int y, boolean[][] visited, int m) {
        int attacks = -1;
        while(x >= 0 && y >= 0 && x < m && y < m && !visited[x][y]) {
            if(board[x][y] == 'b')
                attacks++;
            else
                visited[x][y] = true;
            x--;
            y++;
        }
        return attacks;
    }

    private static int findBottomLeft(char[][] board, int x, int y, boolean[][] visited, int m) {
        int attacks = -1;
        while(x >= 0 && y >= 0 && x < m && y < m && !visited[x][y]) {
            if(board[x][y] == 'b')
                attacks++;
            else
                visited[x][y] = true;
            x++;
            y--;
        }
        return attacks;
    }

    private static int findBottomRight(char[][] board, int x, int y, boolean[][] visited, int m) {
        int attacks = -1;
        while(x >= 0 && y >= 0 && x < m && y < m && !visited[x][y]) {
            if(board[x][y] == 'b')
                attacks++;
            else
                visited[x][y] = true;
            x++;
            y++;
        }
        return attacks;
    }

}
