public class Solution {
  public double myPow(double x, int n) {
    double result = pow(x, Math.abs(n));
    return n < 0 ? 1 / result : result;
  }
  
  private double pow(double x, int n)  {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    double temp = x * x;
    if (n % 2 == 0) {
      return pow(temp, n / 2);
    } else {
      return x * pow(temp, n / 2);
    }
  }
}