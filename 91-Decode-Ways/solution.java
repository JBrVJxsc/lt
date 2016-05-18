public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[s.length()];
        for (int i = s.length() - 1; 0 <= i; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                continue;
            }
            
            if (i == s.length() - 1) {
                map[i] = 1;
            } else if (i == s.length() - 2) {
                map[i] += map[i + 1];
                if (c == '1' || c == '2' && s.charAt(i + 1) < '7') {
                    map[i] += 1;
                }
            } else {
                map[i] += map[i + 1];
                if (c == '1' || c == '2' && s.charAt(i + 1) < '7') {
                    map[i] += map[i + 2];
                }                
            }
        }
        return map[0];
    }
}