public class Solution {
  public String countAndSay(int n) {
    String s = "1";
    if (n == 0) {
      return "";
    }
    
    for (int i = 1; i < n; i++) {
      s = countAndSay(s);
    }
    
    return s;
  }

  private String countAndSay(String s) {
    StringBuilder sb = new StringBuilder();
    char cur = s.charAt(0);
    int len = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == cur) {
        len++;
      } else {
        sb.append(len);
        sb.append(cur);
        cur = s.charAt(i);
        len = 1;
      }
    }
    sb.append(len);
    sb.append(cur);
    return sb.toString();
  }
}