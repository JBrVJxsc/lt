public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    
    int row = grid.length;
    int col = grid[0].length;
    int num = 0;
    boolean[][] visited = new boolean[row][col];
    
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (dfs(grid, i, j, row, col, visited) > 0) {
          num++;
        }
      }
    }
    
    return num;
  }
  
  private int dfs(char[][] grid, int x, int y, int row, int col, boolean[][] visited) {
    if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || grid[x][y] != '1') {
      return 0;
    }
    
    visited[x][y] = true;
    int size = 1;
    size += dfs(grid, x - 1, y, row, col, visited);
    size += dfs(grid, x + 1, y, row, col, visited);
    size += dfs(grid, x, y - 1, row, col, visited);
    size += dfs(grid, x, y + 1, row, col, visited);
    
    return size;
  }
}