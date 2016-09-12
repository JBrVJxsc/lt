public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if (n < 4) {
            return lists;
        }
        List<Integer> factors = factors(n);
        dfs(n, factors, lists, new ArrayList<>(), 1, 0);
        return lists;
    }
    
    private void dfs(int n, List<Integer> factors, List<List<Integer>> lists, List<Integer> cur, int curProd, int index) {
        if (curProd == n) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = index; i < factors.size(); i++) {
            int num = factors.get(i);
            if (curProd > n / num) {
                return;
            }
            cur.add(num);
            curProd *= num;
            dfs(n, factors, lists, cur, curProd, i);
            curProd /= num;
            cur.remove(cur.size() - 1);
        }
    }
    
    private List<Integer> factors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}