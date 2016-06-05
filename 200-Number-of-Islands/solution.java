public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    
    int counter = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          if (dfs(grid, i, j, visited) > 0) {
            counter++;
          }
        }
      }
    }
    
    return counter;
  }
  
  private int dfs(char[][] grid, int x, int y, boolean[][] visited) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
      return 0;
    }
    if (grid[x][y] == '0') {
      return 0;
    }
    visited[x][y] = true;
    int num = 1;
    num += dfs(grid, x + 1, y, visited);
    num += dfs(grid, x - 1, y, visited);
    num += dfs(grid, x, y + 1, visited);
    num += dfs(grid, x, y - 1, visited);
    return num;
  }
}