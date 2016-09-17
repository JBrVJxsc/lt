public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if (n < 4) {
            return lists;
        }
        
        List<Integer> factors = factors(n);
        dfs(lists, factors, new ArrayList<>(), 1, n, 0);
        return lists;
    }
 
    private void dfs(List<List<Integer>> lists, List<Integer> factors, List<Integer> cur, int curProd, int n, int index) {
        if (curProd == n) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = index; i < factors.size(); i++) {
            int num = factors.get(i);
            if (curProd > n / num) {
                return;
            }
            curProd *= num;
            cur.add(num);
            dfs(lists, factors, cur, curProd, n, i);
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