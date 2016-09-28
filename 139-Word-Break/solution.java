public class Solution {
    public boolean wordBreak(String s, Set<String> words) {
        if (s == null || s.length() == 0 || words == null || words.size() == 0) {
            return false;
        }
        return dfs(s, words, 0, new boolean[s.length()], new boolean[s.length()]);
    }
    
    private boolean dfs(String s, Set<String> words, int index, boolean[] visited, boolean[] result) {
        if (index == s.length()) {
            return true;
        }
        if (visited[index]) {
            return result[index];
        }
        visited[index] = true;
        for (int i = index; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (words.contains(sub)) {
                    if (dfs(s, words, j, visited, result)) {
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        
        return result[index];
    }
}