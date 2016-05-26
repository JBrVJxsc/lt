public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null) {
      throw new IllegalArgumentException("grid cannot be null.");
    }
    
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int num = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int n = dfs(grid, visited, i, j);
        if (n > 0) {
          num++;
        }
      }
    }
    
    return num;
  }
  
  private int dfs(char[][] grid, boolean[][] visited, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return 0;
    }
    
    if (visited[row][col] || grid[row][col] == '0') {
      return 0;
    }
    
    visited[row][col] = true;
    
    int num = 1;
    num += dfs(grid, visited, row, col + 1);
    num += dfs(grid, visited, row, col - 1);
    num += dfs(grid, visited, row + 1, col);
    num += dfs(grid, visited, row - 1, col);
    
    return num;
  }
}