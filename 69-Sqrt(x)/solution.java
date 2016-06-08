public class Solution {
    // public int (int x) {
        
    // }
    
      public int mySqrt(int x) {
    if (x < 1) {
      return x;
    }
    return binary(x, 1, x);
  }
  
  private int binary(int x, int left, int right) {
    int mid = left + (right - left) / 2;
    if (mid == x / mid) {
      return mid;
    } else if (mid > x / mid) {
      return binary(x, left, mid - 1);
    } else {
      if (mid + 1 > x / (mid + 1)) {
        return mid;
      }        
      return binary(x, mid + 1, right);
    }
  }
}