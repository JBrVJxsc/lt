public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        dfs(nums, new HashSet<>(), lists, new ArrayList<>());
        return lists;
    }
    
    private void dfs(int[] nums, Set<Integer> set, List<List<Integer>> lists, List<Integer> cur) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i) || i != 0 && nums[i] == nums[i - 1] && set.contains(i - 1)) {
                continue;
            }
            cur.add(nums[i]);
            set.add(i);
            dfs(nums, set, lists, cur);
            set.remove(i);
            cur.remove(cur.size() - 1);
        }
    }
}