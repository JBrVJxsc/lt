public class Solution {
  public boolean wordBreak(String s, Set<String> dict) {
    boolean[] visited = new boolean[s.length()];
    boolean[] result = new boolean[s.length()];
    return dfs(s, dict, 0, visited, result);
  }
  
  private boolean dfs(String s, Set<String> dict, int index, boolean[] visited, boolean[] result) {
    if (index == s.length()) {
      return true;
    }
    
    if (visited[index]) {
      return result[index];
    }
    visited[index] = true;
    
    for (int i = index; i < s.length(); i++) {
      String sub = s.substring(index, i + 1);
      if (!dict.contains(sub)) {
        continue;
      }
      if (dfs(s, dict, i + 1, visited, result)) {
        result[index] = true;
        break;
      }
    }
    
    return result[index];
  }
}