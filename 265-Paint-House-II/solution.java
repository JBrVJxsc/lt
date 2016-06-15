public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    
    for (int i = 1; i < costs.length; i++) {
      int[] mins = minTwo(costs[i - 1]);
      for (int j = 0; j < costs[i].length; j++) {
        if (costs[i - 1][j] == mins[0]) {
          costs[i][j] += mins[1];
        } else {
          costs[i][j] += mins[0];
        }
      }
    }
    
    return minTwo(costs[costs.length - 1])[0];
  }
  
  private int[] minTwo(int[] nums) {
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