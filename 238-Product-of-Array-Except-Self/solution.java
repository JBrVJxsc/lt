public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            l[i] = pre;
            pre *= nums[i];
        }
        
        pre = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            r[i] = pre;
            pre *= nums[i];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = l[i] * r[i];
        }
        
        return result;
    }
}