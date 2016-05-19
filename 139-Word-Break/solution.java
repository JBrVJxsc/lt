public class Solution {
    
    private boolean[] visited = null;
    private boolean[] dp = null;
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        visited = new boolean[s.length()];
        dp = new boolean[s.length()];
        return dfs(s, wordDict, 0);
    }
    
    private boolean dfs(String s, Set<String> wordDict, int start) {
        if (start >= s.length()) {
            return true;
        }
        if (visited[start]) {
            return dp[start];
        }
        visited[start] = true;
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (wordDict.contains(str)) {
                dp[start] = dfs(s, wordDict, i);
                if (dp[start]) {
                    return true;
                }
            }
        }
        return false;
    }
}