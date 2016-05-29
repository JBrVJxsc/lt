public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    
    for (int i : nums) {
      if (i <= min1) {
        min1 = i;
      } else if (i <= min2) {
        min2 = i;
      } else {
        return true;
      }
    }
    
    return false;
  }
}


  
  
  
  