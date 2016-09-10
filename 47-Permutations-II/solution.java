public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, lists, new ArrayList<Integer>(), visited);
        return lists;
    }

    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, lists, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
