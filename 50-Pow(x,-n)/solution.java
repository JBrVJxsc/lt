public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, n);
        }
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double d = pow(x, n / 2);
        d *= d;
        if (n % 2 != 0) {
            d *= x;
        }
        
        return d;
    }
}