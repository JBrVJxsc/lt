public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    int max = 0;
    
    for (int i : prices) {
      min = Math.min(min, i);
      max = Math.max(max, i - min);
    }
    
    return max;
  }
}