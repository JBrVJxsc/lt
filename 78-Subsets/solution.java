public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
      throw new IllegalArgumentException("nums cannot be null.");
    }
    
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    
    Arrays.sort(nums);
    
    for (int i = 1; i <= nums.length; i++) {
      dfs(nums, result, new ArrayList<>(), i, 0);
    }
    
    return result;
  }
  
  private void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur, int len, int start) {
    if (cur.size() == len) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int i = start; i < nums.length; i++) {
      cur.add(nums[i]);
      dfs(nums, result, cur, len, i + 1);
      cur.remove(cur.size() - 1);
    }
  }
}