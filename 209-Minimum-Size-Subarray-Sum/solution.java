public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    
    int l = 0;
    int r = 0;
    int sum = 0;
    int min = 0;
    
    while (r < nums.length) {
      while (r < nums.length && sum < s) {
        sum += nums[r++];
      }
      
      while (l < nums.length && sum >= s) {
        sum -= nums[l++];
        if (sum < s) {
          int len = r - l + 1;
          if (min == 0) {
            min = len;
          } else {
            min = Math.min(min, len);
          }
        }
      }
    }
    
    return min;
  }
}