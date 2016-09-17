public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        
        int pre = nums[0];
        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = pre;
            pre *= nums[i];
        }
        
        pre = nums[nums.length - 1];
        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
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