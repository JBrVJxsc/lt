public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int l = 0;
    int r = 0;
    int sum = 0;
    int len = 0;

    while (r < nums.length) {
      while (r < nums.length && sum < s) {
        sum += nums[r++];
      }
      
      if (sum < s) {
        break;
      }
      
      while (sum >= s) {
        sum -= nums[l++];
        if (sum < s) {
          int newLen = r - l + 1;
          if (len == 0) {
            len = newLen;
          } else {
            len = Math.min(len, newLen);
          }
        }
      }
    }
    
    return len;
  }
}