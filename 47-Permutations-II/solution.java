public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> lists = new HashSet<>();
    if (nums == null) {
      return new ArrayList<>();
    }
    
    Arrays.sort(nums);
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
      visited[i] = true;
      cur.add(nums[i]);
      dfs(nums, lists, cur, visited);
      cur.remove(cur.size() - 1);
      visited[i] =false;
    }
  }
}