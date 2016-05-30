public class Solution {
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    
    int row = rooms.length;
    int col = rooms[0].length;
    boolean[][] visited = new boolean[row][col];
    
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }
    
    while (!queue.isEmpty()) {
      int[] pos = queue.remove();
      int x = pos[0];
      int y = pos[1];
      int dis = rooms[x][y];
      
      if (x > 0 && !visited[x - 1][y] && rooms[x - 1][y] > 0) {
        queue.add(new int[]{x - 1, y});
        rooms[x - 1][y] = dis + 1;
        visited[x - 1][y] = true;
      }
      if (y > 0 && !visited[x][y - 1] && rooms[x][y - 1] > 0) {
        queue.add(new int[]{x, y - 1});
        rooms[x][y - 1] = dis + 1;
        visited[x][y - 1] = true;
      }
      if (x < rooms.length - 1 && !visited[x + 1][y] && rooms[x + 1][y] > 0) {
        queue.add(new int[]{x + 1, y});
        rooms[x + 1][y] = dis + 1;
        visited[x + 1][y] = true;
      }
      if (y < rooms[0].length - 1 && !visited[x][y + 1] && rooms[x][y + 1] > 0) {
        queue.add(new int[]{x, y + 1});
        rooms[x][y + 1] = dis + 1;
        visited[x][y + 1] = true;
      }      
    }
  }
}