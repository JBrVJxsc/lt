public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int root = sqrt(num);
        if (root * root == num) {
            return true;
        }
        return false;
    }
    
    private int sqrt(int num) {
        if (num < 2) {
            return num;
        }
        return binary(num, 1, num);
    }
    
    private int binary(int num, int l, int r) {
        int m = l + (r - l) / 2;
        if (m == num / m) {
            return m;
        } else if (m > num / m) {
            return binary(num, l, m - 1);
        } else {
            m += 1;
            if (m == num / m) {
                return m;
            } else if (m > num / m) {
                return m - 1;
            } else {
                return binary(num, m, r);
            }
        }
    }
}