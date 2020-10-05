package src.solutions.myOwn;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path {

    private static class Point {
        int row;
        int col;
        int distance;
        Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}
        };

        int dist = findMinDistance(grid);
        System.out.println("Shortest Distance from source - destination = " + dist);
    }

    private static int findMinDistance(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Visited array to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Treat obstacles as visited
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '0')
                    visited[i][j] = true;
            }
        }

        // Queue for BFS
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 's') {
                    Point origin = new Point(i,j,0);
                    q.offer(origin);
                    visited[i][j] = true;
                    break;
                }
            }
            break;
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            if(grid[p.row][p.col] == 'd')
                return p.distance;

            // go left
            if(p.col - 1 >= 0 && !visited[p.row][p.col-1]) {
                visited[p.row][p.col-1] = true;
                q.offer(new Point(p.row, p.col - 1, p.distance + 1));
            }
            // go up
            if(p.row - 1 >= 0 && !visited[p.row-1][p.col]) {
                visited[p.row-1][p.col] = true;
                q.offer(new Point(p.row-1, p.col, p.distance + 1));
            }
            // go right
            if(p.col + 1 < grid[0].length && !visited[p.row][p.col + 1]) {
                visited[p.row][p.col + 1] = true;
                q.offer(new Point(p.row, p.col + 1, p.distance + 1));
            }
            // go down
            if(p.row + 1 < grid.length && !visited[p.row+1][p.col]) {
                visited[p.row+1][p.col] = true;
                q.offer(new Point(p.row + 1, p.col, p.distance + 1));
            }

        }
        return -1;
    }
}
