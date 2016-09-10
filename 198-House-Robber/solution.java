public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int pre = nums[0];
        int prePre = 0;
        int max = pre;
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(pre, nums[i] + prePre);
            prePre = pre;
            pre = max;
        }
        
        return max;
    }
}