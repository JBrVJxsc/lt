public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        int counter = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(grid, i, j, row, col) > 0) {
                    counter++;
                }
            }
        }
        
        return counter;
    }
    
    private int dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return 0;
        }
        grid[i][j] = '#';
        
        int counter = 1;
        counter += dfs(grid, i - 1, j, row, col);
        counter += dfs(grid, i + 1, j, row, col);
        counter += dfs(grid, i, j - 1, row, col);
        counter += dfs(grid, i, j + 1, row, col);
        
        return counter;
    }
}