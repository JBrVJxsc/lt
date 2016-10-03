public class Solution {
    public double myPow(double x, int n) {       
        boolean isNeg = n < 0;
        n = Math.abs(n);
        
        if (isNeg) {
            return 1 / pow(x, n);
        }
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double r = pow(x, n / 2);
        if (n % 2 == 0) {
            return r * r;
        }
        return r * r * x;
    }
}