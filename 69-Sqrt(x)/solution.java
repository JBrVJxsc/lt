public class Solution {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }
    
    return binary(1, x, x);
  }
  
  private int binary(int left, int right, int x) {
    int mid = left + (right - left) / 2;
    if (mid == x / mid) {
      return mid;
    } else if (mid > x / mid) {
      return binary(left, mid, x);
    } else if (mid + 1 > x / (mid + 1)) {
      return mid;
    } else {
      return binary(mid, right, x);
    }
  }
}