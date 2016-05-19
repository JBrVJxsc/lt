public class Solution {
    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s cannot be null.");
        }
        
        if (s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length()];
        for (int i = s.length() - 1; 0 <= i; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            // dp[i] = dp[i + 1] + dp[i + 2].
            if (i == s.length() - 1) {
                dp[i] = 1;
            } else {
                dp[i] += dp[i + 1];
                if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7') {
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