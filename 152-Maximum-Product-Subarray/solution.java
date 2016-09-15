public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int curMax = n;
            curMax = Math.max(curMax, n * preMax);
            curMax = Math.max(curMax, n * preMin);
            
            int curMin = n;
            curMin = Math.min(curMin, n * preMax);
            curMin = Math.min(curMin, n * preMin);
            preMin = curMin;
            
            preMax = curMax;
            max = Math.max(max, curMax);
        }
        
        return max;
    }
}