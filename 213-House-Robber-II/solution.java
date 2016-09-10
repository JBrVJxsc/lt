public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = rob(nums, 0, nums.length - 2);
        return Math.max(max, rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] nums, int lo, int hi) {        
        int pre = nums[lo];
        int prePre = 0;
        int max = pre;
        
        for (int i = lo + 1; i <= hi; i++) {
            max = Math.max(pre, nums[i] + prePre);
            prePre = pre;
            pre = max;
        }
        
        return max;
    }
}