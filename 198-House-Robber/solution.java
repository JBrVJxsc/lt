public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                nums[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
            }
        }
        
        return nums[nums.length - 1];
    }
}