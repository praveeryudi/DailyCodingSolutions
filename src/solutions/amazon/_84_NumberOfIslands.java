package src.solutions.amazon;

/**
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix.
 * A 1 represents land and 0 represents water,
 * so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.
 *
 * For example, this matrix has 4 islands.
 *
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 */
public class _84_NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0,0},
                {0,0,1,1,0},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,0,1},
                {1,1,0,0,1}
        };

        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        System.out.println("# of islands= " + islands);
    }

    private static void dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return;

        grid[r][c] = 0;

        dfs(grid, r-1, c-1);
        dfs(grid, r-1, c);
        dfs(grid, r-1, c+1);
        dfs(grid, r, c+1);
        dfs(grid, r+1, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r+1, c-1);
        dfs(grid, r, c-1);
    }

}
