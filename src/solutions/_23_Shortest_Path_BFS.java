package src.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 *
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 * If there is no possible path, then return null. You can move up, left, down, and right.
 * You cannot move through walls. You cannot wrap around the edges of the board.
 *
 * For example, given the following board:
 *
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
 * since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

public class _23_Shortest_Path_BFS {

    public static void main(String[] args) {
        boolean[][] grid = {
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };

        int[] start = {3, 0};
        int[] stop = {0, 0};

        Integer minSteps = getStepsCount(grid, start, stop);
        System.out.println("Min steps = " + minSteps);
    }

    private static class Cell {
        int row;
        int col;
        int distance;
        Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private static Integer getStepsCount(boolean[][] grid, int[] start, int[] stop) {

        int startRow = start[0];
        int startCol = start[1];
        if(grid[startRow][startCol])
            return null;

        int stopRow = stop[0];
        int stopCol = stop[1];
        if(grid[stopRow][stopCol])
            return null;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        // Mark all walls as visited
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j]) {
                    visited[i][j] = true;
                }
            }
        }

        Queue<Cell> q = new LinkedList<>();
        Cell startCell = new Cell(startRow, startCol, 0);
        q.offer(startCell);

        while(!q.isEmpty()) {
            Cell currentCell = q.poll();
            if(currentCell.row == stopRow && currentCell.col == stopCol)
                return currentCell.distance;

            // Move left
            if(currentCell.col > 0 && !visited[currentCell.row][currentCell.col - 1]) {
                visited[currentCell.row][currentCell.col - 1] = true;
                q.add(new Cell(currentCell.row, currentCell.col - 1, currentCell.distance + 1));
            }

            // Move up
            if(currentCell.row > 0 && !visited[currentCell.row - 1][currentCell.col]) {
                visited[currentCell.row - 1][currentCell.col] = true;
                q.add(new Cell(currentCell.row - 1, currentCell.col, currentCell.distance + 1));
            }

            // Move right
            if(currentCell.col + 1 < cols && !visited[currentCell.row][currentCell.col + 1]) {
                visited[currentCell.row][currentCell.col + 1] = true;
                q.add(new Cell(currentCell.row, currentCell.col + 1, currentCell.distance + 1));
            }

            // Move down
            if(currentCell.row + 1 < rows && !visited[currentCell.row + 1][currentCell.col]) {
                visited[currentCell.row + 1][currentCell.col] = true;
                q.add(new Cell(currentCell.row + 1, currentCell.col, currentCell.distance + 1));
            }
        }
        return null;
    }

}
