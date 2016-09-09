public class Solution {
    public int maxProduct(int[] nums) {
        int maxPre = nums[0];
        int minPre = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int maxHere = nums[i];
            maxHere = Math.max(maxHere, nums[i] * maxPre);
            maxHere = Math.max(maxHere, nums[i] * minPre);
            
            int minHere = nums[i];
            minHere = Math.min(minHere, nums[i] * maxPre);
            minHere = Math.min(minHere, nums[i] * minPre);
            
            max = Math.max(max, maxHere);
            
            maxPre = maxHere;
            minPre = minHere;
        }
        
        return max;
    }
}