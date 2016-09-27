public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();
        boolean[][] map = new boolean[len][len];
        int l = 0;
        int r = 0;
        
        for (int i = 0; i < len; i++) {
            map[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                l = i;
                r = i + 1;
                map[l][r] = true;
            }
        }
        
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && map[j + 1][j + i - 2]) {
                    l = j;
                    r = j + i - 1;
                    map[l][r] = true;
                }
            }
        }
        
        return s.substring(l, r + 1);
    }
}