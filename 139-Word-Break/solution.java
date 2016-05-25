public class Solution {
  private boolean[] visited = null;
  private boolean[] result = null;

  public boolean wordBreak(String s, Set<String> wordDict) {
    visited = new boolean[s.length()];
    result = new boolean[s.length()];         
    return dfs(s, wordDict, 0);
  }

  private boolean dfs(String s, Set<String> wordDict, int i) {
    if (i >= s.length()) {
      return true;
    }
    
    if (visited[i]) {
      return result[i];
    }
    
    visited[i] = true;
    
    for (int j = i + 1; j <= s.length(); j++) {
      String sub = s.substring(i, j);
      if (!wordDict.contains(sub)) {
        continue;
      }
      boolean b = dfs(s, wordDict, j);
      if (b) {
        result[i] = true;
        break;
      }
    }
    
    return result[i];
  }
}