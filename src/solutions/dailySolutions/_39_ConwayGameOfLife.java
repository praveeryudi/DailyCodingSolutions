package src.solutions.dailySolutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _39_ConwayGameOfLife {

    private static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private char[][] board;
    private Queue<Cell> q;
    private int steps;

    private _39_ConwayGameOfLife(int rows, int cols, int[][] liveCells, int steps) {
        this.board = new char[rows][cols];
        this.steps = steps;
        this.q = new LinkedList<>();
        // Initialize all cells as dead cells
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        for(int[] liveCell : liveCells) {
            this.board[liveCell[0]][liveCell[1]] = '*';
        }
    }

    private void fillQueue() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                q.add(new Cell(r, c));
            }
        }
    }

    private void playGame() {

        int step = 0;

        fillQueue();

        while(!q.isEmpty() && step <= steps) {

            int size = q.size();
            while(size > 0) {
                Cell currCell = q.poll();
                char currCellState = board[currCell.x][currCell.y];
                int aliveCount = getAliveNeighbors(currCell.x, currCell.y);

                // If current cell is a live cell
                if(currCellState == '*' && aliveCount < 2) {
                    board[currCell.x][currCell.y] = '.';
                }
                else if(currCellState == '*' && (aliveCount == 2 || aliveCount == 3)) {
                    board[currCell.x][currCell.y] = '*';
                }
                else if(currCellState == '*' && aliveCount > 3) {
                    board[currCell.x][currCell.y] = '.';
                }
                else if(currCellState == '.' && aliveCount == 3) {
                    board[currCell.x][currCell.y] = '*';
                }
                size--;
            }
            System.out.println("Board after step: " + step);
            printBoard();
            fillQueue();
            step++;
        }

    }

    private boolean isWithinBounds(int r, int c) {
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }

    private int getAliveNeighbors(int r, int c) {
        int count = 0;
        if(isWithinBounds(r-1, c-1) && board[r-1][c-1] == '*')
            count++;
        if(isWithinBounds(r-1, c) && board[r-1][c] == '*')
            count++;
        if(isWithinBounds(r-1, c+1) && board[r-1][c+1] == '*')
            count++;
        if(isWithinBounds(r, c-1) && board[r][c-1] == '*')
            count++;
        if(isWithinBounds(r, c+1) && board[r][c+1] == '*')
            count++;
        if(isWithinBounds(r+1, c-1) && board[r+1][c-1] == '*')
            count++;
        if(isWithinBounds(r+1, c) && board[r+1][c] == '*')
            count++;
        if(isWithinBounds(r+1, c+1) && board[r+1][c+1] == '*')
            count++;
        return count;
    }

    private void printBoard() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] liveCells = {
                {0,0}, {1,1}, {2,2}
        };
        _39_ConwayGameOfLife obj = new _39_ConwayGameOfLife(3,3,liveCells, 3);
        System.out.println("Initial Board State:");
        obj.printBoard();
        obj.playGame();

    }

}
