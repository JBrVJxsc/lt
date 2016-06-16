public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, s.length() - 1, 0, p.length() - 1);
    }
    
    private boolean isMatch(String s, String p, int sL, int sR, int pL, int pR) {
        int sLen = sR - sL + 1;
        int pLen = pR - pL + 1;
        if (pLen == 0) {
            return sLen == 0;
        }
        if (pLen == 1 || p.charAt(pL + 1) != '*') {
            if (sLen == 0) {
                return false;
            }
            if (match(s, p, sL, pL)) {
                return isMatch(s, p, sL + 1, sR, pL + 1, pR);
            }
            return false;
        }
        if (p.charAt(pL + 1) == '*') {
            if (isMatch(s, p, sL, sR, pL + 2, pR)) {
                return true;
            }
            int i = 0;
            while (i < sLen && match(s, p, sL + i, pL)) {
                if (isMatch(s, p, sL + i + 1, sR, pL + 2, pR)) {
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