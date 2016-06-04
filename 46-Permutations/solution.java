public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    
    dfs(nums, result, new ArrayList<>(), new boolean[nums.length]);
    
    return result;
  }
  
  private void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur, boolean[] visited) {
    if (cur.size() == nums.length) {
      result.add(new ArrayList<>(cur));
      return;
    }
    
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      cur.add(nums[i]);
      dfs(nums, result, cur, visited);
      cur.remove(cur.size() - 1);
      visited[i] = false;
    }
  }
}