public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x cannot be less than 0.");
        }
        if (x < 2) {
            return x;
        }
        return binary(x, 1, x);
    }
    
    private int binary(int x, int l, int r) {
        int m = l + (r - l) / 2;
        if (m == x / m) {
            return m;
        } else if (m > x / m) {
            return binary(x, l, m - 1);
        } else {
            m += 1;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                return m - 1;
            } else {
                return binary(x, m, r);
            }
        }
    }
}