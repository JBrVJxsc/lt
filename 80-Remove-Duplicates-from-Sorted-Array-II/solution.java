public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length < 3) {
      return nums.length;
    }
    
    int cur = 2;
    for (int i = cur; i < nums.length; i++) {
      if (nums[i] != nums[cur - 2]) {
        nums[cur++] = nums[i];
      }
    }
    
    return cur;
  }
}