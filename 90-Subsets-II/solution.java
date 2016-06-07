public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    
    for (int len = 1; len <= nums.length; len++) {
      dfs(nums, len, 0, new ArrayList<>(), result);
    }
    
    return result;
  }
  
  private void dfs(int[] nums, int len, int index, List<Integer> path, List<List<Integer>> result) {
    if (path.size() == len) {
      result.add(new ArrayList<>(path));
      return;
    }
    
    int i = index;
    while (i < nums.length) {
      path.add(nums[i]);
      dfs(nums, len, i + 1, path, result);
      path.remove(path.size() - 1);
      i++;
      while (i < nums.length && index != i && nums[i] == nums[i - 1]) {
        i++;
      }
    }
  }
}