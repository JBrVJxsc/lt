public class Solution {
  public String convertToTitle(int n) {
    if (n < 27) {
      return convert(n);
    }
    if (n % 26 == 0) {
      return convertToTitle(n / 26 - 1) + convertToTitle(26);
    }
    return convertToTitle(n / 26) + convertToTitle(n % 26);
  }
  
  private String convert(int n) {
    return String.valueOf((char)('A' + n - 1));
  }
}