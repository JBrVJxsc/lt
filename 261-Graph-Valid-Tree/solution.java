public class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (n < 2) {
      return true;
    }
    
    if (edges == null || edges.length == 0 || edges[0].length == 0) {
      return false;
    }
    
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      if (map.get(edge[0]) == null) {
        map.put(edge[0], new HashSet<>());
      }
      map.get(edge[0]).add(edge[1]);
      if (map.get(edge[1]) == null) {
        map.put(edge[1], new HashSet<>());
      }
      map.get(edge[1]).add(edge[0]);
    }
    
    Set<Integer> set = new HashSet<>();
    dfs(0, map, set);
    
    if (set.size() == n) {
      if (edges.length == n - 1) {
        return true;
      }
    }
    return false;
  }
  
  private void dfs(int node, Map<Integer, Set<Integer>> map, Set<Integer> set) {
    if (set.contains(node) || map.get(node) == null) {
      return;
    }
    set.add(node);
    for (int i : map.get(node)) {
      dfs(i, map, set);
    }
  }
}