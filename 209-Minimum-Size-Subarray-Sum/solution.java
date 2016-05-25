public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int l = 0;
    int r = 0;
    int min = 0;
    int sum = 0;

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
            if (min == 0) {
                min = r - l + 1;
            }
            else {
                min = Math.min(min, r - l + 1);
            }
        }
      }
    }
    
    return min;
  }
}