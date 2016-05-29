public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    int len = nums.length;
    int[] left = new int[len];
    int[] right = new int[len];
    for (int i = 1; i < len; i++) {
      left[i] = left[i - 1] + nums[i - 1];
    }
    for (int i = len - 2; 0 <= i; i--) {
      right[i] = right[i + 1] + nums[i + 1];
    }    
    int total = 0;
    for (int i : nums) {
      total += i;
    }
    
    for (int i = len; 0 < i; i--) {
      for (int j = 0; j <= len - i; j++) {
        int sum = total - left[j] - right[j + i - 1];
        if (sum == k) {
          return i;
        }
      }
    }
    
    return 0;
  }
}