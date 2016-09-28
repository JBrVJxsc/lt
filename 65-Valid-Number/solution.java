public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        
        int numOfDigit = 0;
        int numOfSign = 0;
        int numOfE = 0;
        int numOfDot = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isValid(c)) {
                return false;
            }
            if (isDigit(c)) {
                numOfDigit++;
            }
            if (isDot(c)) {
                if (numOfDot == 1) {
                    return false;
                }
                if (i == s.length() - 1 && numOfDigit == 0) {
                    return false;
                }
                if (numOfE != 0) {
                    return false;
                }
                numOfDot++;
            }
            if (isE(c)) {
                if (numOfE == 1) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (numOfDigit == 0) {
                    return false;
                }
                numOfE++;
            }
            if (isSign(c)) {
                if (numOfSign == 2) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (i != 0 && numOfE == 0) {
                    return false;
                }
                numOfSign++;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return isDot(c) || isE(c) || isSign(c) || isDigit(c);
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