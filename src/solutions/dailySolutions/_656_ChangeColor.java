package solutions.dailySolutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C,
 * replace the color of the given pixel and all adjacent same colored pixels with C.
 *
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 *
 * B B W
 * W W W
 * W W W
 * B B B
 * Becomes
 *
 * B B G
 * G G G
 * G G G
 * B B B
 */
public class _656_ChangeColor {

    private static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isWithinBounds(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'B', 'B', 'W'},
                {'W','W','W'},
                {'W','W','W'},
                {'B','B','B'}
        };

        bfs(grid, 'G', 2, 2);

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println("");
        }

    }

    private static void bfs(char[][] grid, char color, int r, int c) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(r, c));
        char orig_color = grid[r][c];
        grid[r][c] = color;
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Cell curr = q.poll();
            int curr_x = curr.x;
            int curr_y = curr.y;

            // Check left
            if(isWithinBounds(grid.length, grid[0].length, curr_x, curr_y-1) && !visited[curr_x][curr_y-1] && grid[curr_x][curr_y-1] == orig_color) {
                visited[curr_x][curr_y-1] = true;
                grid[curr_x][curr_y-1] = color;
                q.add(new Cell(curr_x, curr_y-1));
            }

            // Check up
            if(isWithinBounds(grid.length, grid[0].length, curr_x-1, curr_y) && !visited[curr_x-1][curr_y] && grid[curr_x-1][curr_y] == orig_color) {
                visited[curr_x-1][curr_y] = true;
                grid[curr_x-1][curr_y] = color;
                q.add(new Cell(curr_x-1, curr_y));
            }

            // Check right
            if(isWithinBounds(grid.length, grid[0].length, curr_x, curr_y+1) && !visited[curr_x][curr_y+1] && grid[curr_x][curr_y+1] == orig_color) {
                visited[curr_x][curr_y+1] = true;
                grid[curr_x][curr_y+1] = color;
                q.add(new Cell(curr_x, curr_y+1));
            }

            // Check down
            if(isWithinBounds(grid.length, grid[0].length, curr_x+1, curr_y) && !visited[curr_x+1][curr_y] && grid[curr_x+1][curr_y] == orig_color) {
                visited[curr_x+1][curr_y] = true;
                grid[curr_x+1][curr_y] = color;
                q.add(new Cell(curr_x+1, curr_y));
            }
        }
    }

}
