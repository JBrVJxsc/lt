public class Solution {
    public double myPow(double x, int n) {
        boolean isPositive = n > 0;
        n = Math.abs(n);
        x = binary(x, n);
        if (!isPositive) {
            return 1 / x;
        }
        return x;
    }
    
    private double binary(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        double r = binary(x, n / 2);
        r *= r;
        if (n % 2 != 0) {
            r *= x;
        }
        
        return r;
    }
}