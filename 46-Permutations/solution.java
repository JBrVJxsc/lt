public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        
        dfs(nums, new ArrayList<>(), lists, new boolean[nums.length]);
        
        return lists;
    }
    
    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> lists, boolean[] visited) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, cur, lists, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}