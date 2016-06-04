public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    for (int i = 1; i <= nums.length; i++) {
      dfs(nums, 0, i, result, new ArrayList<>());
    }
    return result;
  }
  
  private void dfs(int[] nums, int start, int len, List<List<Integer>> result, List<Integer> cur) {
    if (cur.size() == len) {
      result.add(new ArrayList<>(cur));
      return;
    }
    int i = start;
    while (i < nums.length) {
      cur.add(nums[i]);
      dfs(nums, i + 1, len, result, cur);
      cur.remove(cur.size() - 1);
      i++;
      while (i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
    }
  }
}