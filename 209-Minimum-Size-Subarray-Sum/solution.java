public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int min = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        
        while (r < nums.length) {
            while (r < nums.length && sum < s) {
                sum += nums[r++];
            }
            
            if (sum >= s) {
                if (min == 0) {
                    min = r - l;
                } else {
                    min = Math.min(min, r - l);
                }
            }
            
            while (sum >= s) {
                sum -= nums[l++];
                min = Math.min(min, r - l + 1);
            }
        }
        
        return min;
    }
}