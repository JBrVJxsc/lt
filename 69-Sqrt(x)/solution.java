public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        return binary(1, x, x);
    }
    
    private int binary(int l, int r, int x) {
        int m = l + (r - l) / 2;
        if (m == x / m) {
            return m;
        }
        if (m < x / m) {
            if (m + 1 > x / (m + 1)) {
                return m;
            }
            return binary(m + 1, r, x);
        }
        return binary(l, m - 1, x);
    }
}