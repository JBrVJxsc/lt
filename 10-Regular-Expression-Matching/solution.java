public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
            if (match(s, p, 0, 0)) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            int i = 0;
            while (i < s.length() && match(s, p, i, 0)) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
        return false;
    }
    
    private boolean match(String s1, String s2, int i1, int i2) {
        char c1 = s1.charAt(i1);
        char c2 = s2.charAt(i2);
        return c1 == c2 || c1 == '.' || c2 == '.';
    }
}