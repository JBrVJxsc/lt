public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        int len = s.length();
        if (len == 0) {
            return false;
        }
        
        int sign = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasDot = false;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (!isValid(c)) {
                return false;
            }
            
            if (isDigit(c)) {
                hasNum = true;
            }
            
            if (isE(c)) {
                if (hasE || !hasNum) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                hasE = true;
            }
            
            if (isDot(c)) {
                if (hasDot || hasE) {
                    return false;
                }
                if (i == len - 1 && !hasNum) {
                    return false;
                }
                hasDot = true;
            }
            
            if (isSign(c)) {
                if (sign == 2) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                if (i > 0 && !hasE) {
                    return false;
                }
                sign++;
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return isDot(c) || isSign(c) || isE(c) || isDigit(c);
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    
    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
    
    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }
    
    private boolean isDot(char c) {
        return c == '.';
    }
}