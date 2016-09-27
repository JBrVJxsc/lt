public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            l[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            r[i] = max;
            max = Math.max(max, height[i]);            
        }
        
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(l[i], r[i]);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}