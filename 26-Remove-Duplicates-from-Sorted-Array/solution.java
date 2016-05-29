public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length < 2) {
      return nums.length;
    }
    
    int cur = 1;
    for (int i = cur; i < nums.length; i++) {
      if (nums[i] != nums[cur - 1]) {
        nums[cur++] = nums[i];
      }
    }
    
    return cur;
  }
}