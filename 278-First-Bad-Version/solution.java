/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binary(1, n);
    }
    
    private int binary(int left, int right) {
        int mid = left + (right - left) / 2;
        boolean isBad = isBadVersion(mid);
        if (!isBad) {
            return binary(mid + 1, right);
        } else {
            isBad = isBadVersion(mid - 1);
            if (isBad) {
                return binary(left, mid - 1);
            } else {
                return mid;
            }
        }
    }
}