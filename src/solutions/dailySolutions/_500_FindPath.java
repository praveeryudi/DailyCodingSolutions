package src.solutions.dailySolutions;

import java.util.LinkedList;
import java.util.Queue;

public class _500_FindPath {

    private static class Path {
        int x;
        int y;
        int distance;
        Path(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static boolean isWithinBounds(int rows, int cols, int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    private static int getMinSteps(boolean[][] grid, int[] start, int[] end) {

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Path> q = new LinkedList<>();
        q.add(new Path(start[0], start[1], 0));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Path temp = q.poll();
                if(temp.x == end[0] && temp.y == end[1])
                    return temp.distance;
                // Go left
                if(isWithinBounds(rows, cols, temp.x, temp.y - 1) && !grid[temp.x][temp.y-1]) {
                    q.add(new Path(temp.x, temp.y-1, temp.distance + 1));
                    grid[temp.x][temp.y-1] = true;
                }

                // Go up
                if(isWithinBounds(rows, cols, temp.x-1, temp.y) && !grid[temp.x-1][temp.y]) {
                    q.add(new Path(temp.x-1, temp.y, temp.distance + 1));
                    grid[temp.x-1][temp.y] = true;
                }

                // Go right
                if(isWithinBounds(rows, cols, temp.x, temp.y + 1) && !grid[temp.x][temp.y+1]) {
                    q.add(new Path(temp.x, temp.y+1, temp.distance + 1));
                    grid[temp.x][temp.y+1] = true;
                }

                // Go down
                if(isWithinBounds(rows, cols, temp.x+1, temp.y) && !grid[temp.x+1][temp.y]) {
                    q.add(new Path(temp.x+1, temp.y, temp.distance + 1));
                    grid[temp.x+1][temp.y] = true;
                }

                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[][] grid = {
                {false, false,false,false},
                {true, true, false, true},
                {false, false,false,false},
                {false, false,false,false}
        };

        int[] start = {3,0};
        int[] end = {0,0};
        int minSteps = getMinSteps(grid, start, end);
        System.out.println(minSteps);
    }

}
