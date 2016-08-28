public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();        
        boolean[][] map = new boolean[len][len];
        int max = 1;
        int start = 0;
        
        for (int i = 0; i < len; i++) {
            map[i][i] = true;
            max = Math.max(max, 1);                         
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                map[i][i + 1] = true;
                max = Math.max(max, 2);
                start = i;
            }
        }
        
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && map[j + 1][j + i - 2]) {
                    map[j][j + i - 1] = true;
                    max = Math.max(max, i);
                    start = j;
                }
            }
        }
        
        return s.substring(start, start + max);
    }
}