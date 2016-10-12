public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, new ArrayList<>(), n, 2);
        return lists;
    }
    
    private void dfs(List<List<Integer>> lists, List<Integer> cur, int n, int start) {
        if (n == 1) {
            if (cur.size() > 1) {
                lists.add(new ArrayList<>(cur));
            }
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                dfs(lists, cur, n / i, i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}