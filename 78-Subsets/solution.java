public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        
        if (nums == null || nums.length == 0) {
            return lists;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            dfs(lists, new ArrayList<>(), i, 0, nums);
        }
        
        return lists;
    }
    
    private void dfs(List<List<Integer>> lists, List<Integer> cur, int len, int index, int[] nums) {
        if (cur.size() == len) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        
        if (index == nums.length) {
            return;
        }        
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(lists, cur, len, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}