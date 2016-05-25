public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    int[] dp = new int[s.length()];
    
    for (int i = s.length() - 1; 0 <= i; i--) {
      char c = s.charAt(i);
      if (c == '0') {
        continue;
      }
      
      if (i == s.length() - 1) {
        dp[i] += 1;
      } else {
        dp[i] += dp[i + 1];
        if (c == '1' || c == '2' && s.charAt(i + 1) < '7') {
          if (i == s.length() - 2) {
            dp[i] += 1;
          } else {
            dp[i] += dp[i + 2];
          }
        }
      }
    }
    
    return dp[0];
  }
}