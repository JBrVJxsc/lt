public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        
        for (int i = 1; i < costs.length; i++) {
            int[] min = min2(costs[i - 1]);
            for (int j = 0; j < k; j++) {
                costs[i][j] += costs[i - 1][j] == min[0] ? min[1] : min[0];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, costs[costs.length - 1][i]);
        }
        
        return min;
    }
  
    private int[] min2(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num < a) {
                b = a;
                a = num;
            } else if (num < b) {
                b = num;
            }
        }
                
        return new int[]{a, b};
    }
}