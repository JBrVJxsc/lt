public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(grid, i, j, row, col) > 0) {
                    count ++;
                }
            }
        }
        return count;
    }
    
    private int dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != '1') {
            return 0;
        }
        grid[x][y] = 'x';
        int num = 1;
        num += dfs(grid, x + 1, y, row, col);
        num += dfs(grid, x - 1, y, row, col);
        num += dfs(grid, x, y + 1, row, col);
        num += dfs(grid, x, y - 1, row, col);
        return num;
    }
}