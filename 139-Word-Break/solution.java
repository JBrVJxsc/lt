public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null) {
            return false;
        }
        boolean[] result = new boolean[s.length()];
        boolean[] visited = new boolean[s.length()];
        return dfs(s, dict, 0, result, visited);
    }
    
    private boolean dfs(String s, Set<String> dict, int index, boolean[] result, boolean[] visited) {
        if (index == s.length()) {
            return true;
        }
        
        if (visited[index]) {
            return result[index];
        }
        visited[index] = true;
        
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (dict.contains(sub) && dfs(s, dict, i + 1, result, visited)) {
                result[index] = true;
            }
        }
        
        return result[index];
    }
}