package solutions.myOwn;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {7,1,1,1},
                {1,7,7,7},
                {7,7,7,0},
                {7,7,7,4},
                {4,4,4,4}
        };
        floodFill(image, 5,4,2,2,5);
        for(int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
        // Write your code here.
        if(image[x][y] == p) {
            return image;
        }
        dfs(image, x,y,image[x][y],p);
        return image;
    }

    private static void dfs(int[][] grid, int r, int c, int orig, int newPixel) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != orig)
            return;
        grid[r][c] = newPixel;
        dfs(grid,r,c-1,orig,newPixel);
        dfs(grid,r-1,c,orig,newPixel);
        dfs(grid,r,c+1,orig,newPixel);
        dfs(grid,r+1,c,orig,newPixel);
    }
}
