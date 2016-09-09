public class Solution {
    public int maxProduct(int[] nums) {
        int preMax = nums[0];
        int preMin = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curMax = nums[i];
            curMax = Math.max(curMax, nums[i] * preMax);
            curMax = Math.max(curMax, nums[i] * preMin);
            
            int curMin = nums[i];
            curMin = Math.min(curMin, nums[i] * preMax);
            curMin = Math.min(curMin, nums[i] * preMin);            
            
            preMax = curMax;
            preMin = curMin;
            
            max = Math.max(max, curMax);
        }
        
        return max;
    }
}