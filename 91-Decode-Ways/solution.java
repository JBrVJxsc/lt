public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    int pre = 0;
    int prePre = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int cur = 0;
      char c = s.charAt(i);
      if (c == '0') {
        prePre = pre;
        pre = cur;
        continue;
      }
      
      if (i == s.length() - 1) {
        cur = 1;
        prePre = pre;
        pre = cur;        
        continue;
      }
      
      cur = pre;
      
      if (c == '1' || c == '2' && s.charAt(i + 1) < '7') {
        if (i == s.length() - 2) {
          cur += 1;
        } else {
          cur += prePre;
        }
      }
      
      prePre = pre;
      pre = cur;      
    }
    
    return pre;
  }
}