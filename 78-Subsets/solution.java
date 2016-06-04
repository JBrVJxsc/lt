public class Solution {
public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
      return new ArrayList<>();
    }
    
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    
    for (int len = 1; len <= nums.length; len++) {
      dfs(nums, 0, len, result, new ArrayList<>());
    }
    
    return result;
  }
  
  private void dfs(int[] nums, int start, int len, List<List<Integer>> lists, List<Integer> cur) {
    if (cur.size() == len) {
      lists.add(new ArrayList<>(cur));
      return;
    }
    
    for (int i = start; i < nums.length; i++) {
      cur.add(nums[i]);
      dfs(nums, i + 1, len, lists, cur);
      cur.remove(cur.size() - 1);
    }
  }
}