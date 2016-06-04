public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    
    for (int len = 1; len <= nums.length; len++) {
      dfs(nums, len, 0, result, new ArrayList<>());
    }
    
    return result;
  }
  
  private void dfs(int[] nums, int len, int start, List<List<Integer>> result, List<Integer> cur) {
    if (cur.size() == len) {
      result.add(new ArrayList<>(cur));
      return;
    }
    
    int i = start;
    while (i < nums.length) {
      cur.add(nums[i]);
      dfs(nums, len, i + 1, result, cur);
      cur.remove(cur.size() - 1);
      i++;
      while (i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
    }
  }
}