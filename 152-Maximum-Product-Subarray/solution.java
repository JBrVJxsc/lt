public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxMap = new int[nums.length];
        int[] minMap = new int[nums.length];
        maxMap[0] = nums[0];
        minMap[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            temp = Math.max(temp, nums[i] * maxMap[i - 1]);
            temp = Math.max(temp, nums[i] * minMap[i - 1]);
            maxMap[i] = temp;
            
            temp = nums[i];
            temp = Math.min(temp, nums[i] * maxMap[i - 1]);
            temp = Math.min(temp, nums[i] * minMap[i - 1]);
            minMap[i] = temp;
            
            max = Math.max(max, maxMap[i]);
        }
        
        return max;
    }
}