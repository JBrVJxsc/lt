public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null) {
      throw new IllegalArgumentException("num1 and num2 cannot be null.");
    }
    
    int len1 = num1.length();
    int len2 = num2.length();
    int[] result = new int[len1 + len2];
  
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        int p1 = i + j;
        int p2 = i + j + 1;
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        mul += result[p2];
        result[p1] += mul / 10;
        result[p2] = mul % 10;
      }
    }
    
    int i = 0;
    while (i < result.length && result[i] == 0) {
      i++;
    }
    
    StringBuilder sb = new StringBuilder();
    for (; i < result.length; i++) {
      sb.append(result[i]);
    }
    
    if (sb.length() == 0) {
      return "0";
    }
    
    return sb.toString();
  }
}