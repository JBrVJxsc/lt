public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        dfs(nums, lists, new ArrayList<>(), new boolean[nums.length]);
        
        return new ArrayList<>(lists);
    }
    
    private void dfs(int[] nums, Set<List<Integer>> lists, List<Integer> cur, boolean[] visited) {
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
            dfs(nums, lists, cur, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}