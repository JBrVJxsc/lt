public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE;
    
    for (int z : nums) {
      if (z <= x) {
        x = z;
      } else if (z <= y) {
        y = z;
      } else {
        return true;
      }
    }
    
    return false;
  }
}