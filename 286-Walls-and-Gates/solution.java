public class Solution {
  
  private int INF = Integer.MAX_VALUE;
  
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null) {
      return;
    }
    if (rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    
    Queue<int[]> q = new LinkedList<>();
    
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == 0) {
          q.add(new int[]{i, j});
        }
      }
    }
    
    while (!q.isEmpty()) {
      int[] p = q.remove();
      int x = p[0];
      int y = p[1];
      int d = rooms[x][y];
      
      if (x > 0 && rooms[x - 1][y] == INF) {
        q.add(new int[]{x - 1, y});
        rooms[x - 1][y] = d + 1;
      }
      if (x < rooms.length - 1 && rooms[x + 1][y] == INF) {
        q.add(new int[]{x + 1, y});
        rooms[x + 1][y] = d + 1;
      }
      if (y > 0 && rooms[x][y - 1] == INF) {
        q.add(new int[]{x, y - 1});
        rooms[x][y - 1] = d + 1;
      }
      if (y < rooms[x].length - 1 && rooms[x][y + 1] == INF) {
        q.add(new int[]{x, y + 1});
        rooms[x][y + 1] = d + 1;
      }      
    }
  }
}