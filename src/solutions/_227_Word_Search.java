package solutions;

import java.util.Arrays;

public class _227_Word_Search {

    private static boolean dfs(char[][] grid, int i, int j, int count, String word) {

        if(count == word.length())
            return true;

        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] != word.charAt(count))
            return false;

        char temp = grid[i][j];
        grid[i][j] = '\0';
        boolean isFound = dfs(grid, i-1, j, count+1, word) ||
                dfs(grid, i+1, j, count+1, word) ||
                dfs(grid, i, j-1, count+1, word) ||
                dfs(grid, i, j+1, count+1, word) ||
                dfs(grid, i-1, j-1, count+1, word) ||
                dfs(grid, i+1, j-1, count+1, word) ||
                dfs(grid, i-1, j+1, count+1, word) ||
                dfs(grid, i+1, j+1, count+1, word);
        if(!isFound)
            grid[i][j] = temp;
        return isFound;
    }

    private static boolean checkWord(char[][] grid, String word) {
        boolean isFound = false;
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 4; c++) {
                if(grid[r][c] == word.charAt(0) && dfs(grid, r, c, 0, word)) {
                    isFound = true;
                    break;
                }
            }
        }
        return isFound;
    }

    public static void main(String[] args) {

        char[][] grid = new char[][] {
                {'c', 'j', 'z', 'e'},
                {'v', 'a', 'x','b'},
                {'x', 'n', 't', 'u'},
                {'i', 'a', 'n', 'k'}
        };

        String[] words = new String[] {"cat", "dog", "byte", "tube", "can", "ant", "car", "tank"};
        for(String word : words) {
            char[][] copy  = Arrays.stream(grid).map(char[]::clone).toArray(char[][]::new);
            if(checkWord(copy, word)) {
                System.out.println(word + " found.");
            }
        }
    }
}