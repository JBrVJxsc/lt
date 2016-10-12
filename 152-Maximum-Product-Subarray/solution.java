public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int preMin = nums[0];
        int preMax = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curMin = nums[i];
            curMin = Math.min(curMin, nums[i] * preMax);
            curMin = Math.min(curMin, nums[i] * preMin);
            
            int curMax = nums[i];
            curMax = Math.max(curMax, nums[i] * preMax);
            curMax = Math.max(curMax, nums[i] * preMin);
            
            max = Math.max(max, curMax);
            preMin = curMin;
            preMax = curMax;
        }
        
        return max;
    }
}