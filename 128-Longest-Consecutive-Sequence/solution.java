public class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null) {
      return 0;
    }
    
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    
    int max = 0;
    
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      if (!set.contains(n)) {
        continue;
      }
      int len = 0;
      while (set.contains(n)) {
        set.remove(n);
        len++;
        n++;
      }
      n = nums[i] - 1;
      while (set.contains(n)) {
        set.remove(n);
        len++;
        n--;
      }
      max = Math.max(max, len);
    }
    
    return max;
  }
}