/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    return binary(1, n);
  }
  
  private int binary(int left, int right) {
    int mid = left + (right - left) / 2;
    if (isBadVersion(mid)) {
      if(!isBadVersion(mid - 1)) {
        return mid;
      } else {
        return binary(left, mid - 1);
      }
    } else {
      return binary(mid + 1, right);
    }
  }
}