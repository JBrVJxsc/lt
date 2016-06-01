public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }
    for (int i = 1; i < costs.length; i++) {
      int[] min = twoMin(costs[i - 1]);
      for (int j = 0; j < costs[i].length; j++) {
        if (costs[i - 1][j] == min[0]) {
          costs[i][j] += min[1];
        } else {
          costs[i][j] += min[0];
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < costs[costs.length - 1].length; i++) {
      min = Math.min(min, costs[costs.length - 1][i]);
    }
    return min;
  }
  
  private int[] twoMin(int[] nums) {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;
    
    for (int i : nums) {
      if (i < a) {
        b = a;
        a = i;
      } else if (i < b){
        b = i;
      }
    }
    
    return new int[]{a, b};
  }
}