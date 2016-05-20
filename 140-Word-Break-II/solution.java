public class Solution {
    private boolean[] visited = null;
    private List[] result = null;
    
    public List<String> wordBreak(String s, Set<String> dict) {
        visited = new boolean[s.length()];
        result = new List[s.length()];
        return dfs(s, dict, 0);
    }
    
    private List<String> dfs(String s, Set<String> dict, int index) {
        if (index >= s.length()) {
            return null;
        }
        if (visited[index]) {
            return result[index];
        }
        visited[index] = true;
        List<String> list = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (!dict.contains(sub)) {
                continue;
            } else if (i == s.length() - 1) {
                list.add(sub);
                break;
            }
            List<String> l = dfs(s, dict, i + 1);
            if (l == null || l.size() == 0) {
                continue;
            }
            for (String str : l) {
                list.add(sub + " " + str);
            }
        }
        result[index] = list;
        return list;
    }
}