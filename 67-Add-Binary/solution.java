public class Solution {
  public String addBinary(String a, String b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    
    StringBuilder sb = new StringBuilder();
    int remain = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    
    while (i >= 0 || j >= 0) {
      remain += i >= 0 ? a.charAt(i--) - '0' : 0;
      remain += j >= 0 ? b.charAt(j--) - '0' : 0;
      sb.insert(0, remain % 2);
      remain /= 2;
    }
    
    if (remain == 1) {
      sb.insert(0, 1);
    }
    
    return sb.toString();
  }
}