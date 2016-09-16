public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < costs.length; i++) {
            int[] min_2 = min2(costs[i - 1]);
            for (int j = 0; j < costs[i].length; j++) {
                if (costs[i - 1][j] == min_2[0]) {
                    costs[i][j] += min_2[1];
                } else {
                    costs[i][j] += min_2[0];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[costs.length - 1].length; i++) {
            min = Math.min(min, costs[costs.length - 1][i]);
        }
        return min;
    }
    
    private int[] min2(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < a) {
                b = a;
                a = n;
            } else if (n < b) {
                b = n;
            }
        }
        return new int[]{a, b};
    }
}