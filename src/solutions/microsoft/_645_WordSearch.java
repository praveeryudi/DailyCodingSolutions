package solutions.microsoft;

/**
 * Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.
 * <p>
 * For example, given the following matrix:
 * <p>
 * [['F', 'A', 'C', 'I'],
 * ['O', 'B', 'Q', 'P'],
 * ['A', 'N', 'O', 'B'],
 * ['M', 'A', 'S', 'S']]
 * and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.
 */
public class _645_WordSearch {

    public static void main(String[] args) {
        char[][] grid = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'},
        };
        String word = "MASS";
        boolean flag = false;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == word.charAt(0) && dfs(grid, r, c, 0, word)) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag);
    }

    private static boolean dfs(char[][] grid, int r, int c, int count, String word) {
        if (count == word.length())
            return true;

        // check out of bounds
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || word.charAt(count) != grid[r][c])
            return false;

        char temp = grid[r][c];
        grid[r][c] = '\0';
        boolean op1 = dfs(grid, r, c + 1, count + 1, word);
        boolean op2 = dfs(grid, r + 1, c, count + 1, word);
        boolean isFound = op1 || op2;
        grid[r][c] = temp;
        return isFound;
    }

}
