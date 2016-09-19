public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        dfs(lists, nums, new ArrayList<>(), new HashSet<>());
        return lists;
    }
  
    private void dfs(List<List<Integer>> lists, int[] nums, List<Integer> cur, Set<Integer> set) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) {
                continue;
            }
            cur.add(n);
            set.add(n);
            dfs(lists, nums, cur, set);
            set.remove(n);
            cur.remove(cur.size() - 1);
        }
    }
}