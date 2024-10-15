package src.solutions.myOwn;

import java.util.ArrayList;

/**
 * Given a grid of size n*n filled with 0, 1, 2, 3.
 * Check whether there is a path possible from the source to destination.
 * You can traverse up, down, right and left.
 * The description of cells is as follows:
 *
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Wall.
 * Note: There are only a single source and a single destination.
 */
public class RatInAMaze {

    private static int numPaths = 0;

    private static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 3, 3, 3, 0, 0, 3, 0},
                {1, 3, 3, 3, 3, 3, 3, 2},
                {3, 3, 0, 3, 0, 3, 3, 3},
                {3, 3, 3, 0, 0, 3, 3, 0},
                {0, 3, 3, 3, 3, 3, 3, 3},
                {0, 0, 0, 3, 3, 0, 3, 3},
                {0, 3, 0, 3, 3, 3, 3, 0},
                {3, 3, 3, 0, 3, 3, 3, 3}
        };
        System.out.println(is_Possible(grid));
    }

    //Function to find whether a path exists from the source to destination.
    private static boolean is_Possible(int[][] grid)
    {
        // Code here
        if(null == grid || grid.length == 0) return false;
        int rows = grid.length;
        int cols = grid[0].length;

        // Look for source and destination
        boolean[][] visited = new boolean[rows][cols];
        Cell source = null;
        Cell destination = null;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    source = new Cell(r, c);
                }
                else if(grid[r][c] == 2) {
                    destination = new Cell(r, c);
                }
            }
        }

        // Boundary case
        if(null == source || null == destination)
            return false;

        int[][] solArr = new int[rows][cols];
        boolean isPossible = backtrack(grid, "", source.x, source.y, destination.x, destination.y, visited, solArr);

        // Print solution array
        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(solArr[r][c] + " ");
            }
            System.out.println("");
        }

        System.out.println(numPaths);
        return isPossible;
    }

    private static boolean backtrack(int[][] grid, String ans, int sx, int sy, int dx, int dy, boolean[][] visited, int[][] solArr) {

        if(sx == dx && sy == dy)
        {
            numPaths++;
            visited[dx][dy] = true;
            solArr[dx][dy] = 1;
            System.out.println(ans);
            return true;
        }

        // Explore all 4 directions
        if(isSafe(grid, sx, sy) && !visited[sx][sy]) {
            visited[sx][sy] = true;
            solArr[sx][sy] = 1;
            boolean res = backtrack(grid, ans + "L", sx, sy-1, dx, dy, visited, solArr);
            if(res) return true;

            res = backtrack(grid, ans + "U", sx-1, sy, dx, dy, visited, solArr);
            if(res) return true;

            res = backtrack(grid, ans + "R", sx, sy+1, dx, dy, visited, solArr);
            if(res) return true;

            res = backtrack(grid, ans + "D",sx+1, sy, dx, dy, visited, solArr);
            if(res) return true;

            visited[sx][sy] = false;
            solArr[sx][sy-1] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
            return false;
        return true;
    }
}
