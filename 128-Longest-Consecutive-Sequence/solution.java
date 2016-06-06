public class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }
    
    int max = 1;
    
    for (int n : nums) {
      if (!set.contains(n)) {
        continue;
      }
      set.remove(n);
      
      int cur = 1;
      int num = n + 1;
      while (set.contains(num)) {
        set.remove(num++);
        cur++;
      }
      num = n - 1;
      while (set.contains(num)) {
        set.remove(num--);
        cur++;
      }
      
      max = Math.max(max, cur);
    }
    
    return max;
  }
}