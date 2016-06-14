public class Solution {
  private int[] map = null;
  private int[] size = null;
  
  public int countComponents(int n, int[][] edges) {
    map = new int[n];
    size = new int[n];
    
    for (int i = 0; i < n; i++) {
      map[i] = i;
      size[i] = 1;
    }
    
    for (int[] edge : edges) {
      union(edge);
    }
    
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(root(i));
    }
    
    return set.size();
  }
  
  private int root(int n) {
    while (map[n] != n) {
      map[n] = map[map[n]];
      n = map[n];
    }
    return n;
  }
  
  private void union(int[] edge) {
    int root1 = root(edge[0]);
    int root2 = root(edge[1]);
    if (size[root1] < size[root2]) {
      map[root1] = root2;
      size[root2] += size[root1];
    } else {
      map[root2] = root1;
      size[root1] += size[root2];      
    }
  }
}