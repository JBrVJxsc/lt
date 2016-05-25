public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    return binary(1, n);
  }
  
  private int binary(int l, int r) {
    int m = l + (r - l) / 2;
    boolean isBad = isBadVersion(m);
    if (isBad) {
      isBad = isBadVersion(m - 1);
      if (!isBad) {
        return m;
      } else {
        return binary(l, m - 1);
      }
    } else {
      return binary(m + 1, r);
    }
  }
}