public class Solution {
  private String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
  private String[] lessThan20 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private String[] lessThan100 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    return convert(num);
  }

  private String convert(int n) {
    String str = "";
    if (n < 10) {
      str = digits[n];
    } else if (n < 20) {
      str = lessThan20[n - 10];
    } else if (n < 100) {
      str = lessThan100[n / 10] + " " + digits[n % 10];
    } else if (n < 1000) {
      str = convert(n / 100) + " Hundred " + convert(n % 100);
    } else if (n < 1000000) {
      str = convert(n / 1000) + " Thousand " + convert(n % 1000);
    } else if (n < 1000000000) {
      str = convert(n / 1000000) + " Million " + convert(n % 1000000);
    } else str = convert(n / 1000000000) + " Billion " + convert(n % 1000000000);
    return str.trim();
  }
}