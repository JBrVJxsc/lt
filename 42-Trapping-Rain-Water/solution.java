public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        
        int count = 0;        
        for (int i = 1; i < height.length - 1; i++) {
            int dif = Math.min(left[i], right[i]) - height[i];
            count += dif > 0 ? dif : 0;
        }
        return count;
    }
}