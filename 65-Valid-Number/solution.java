public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        
        int numOfDot = 0;
        int numOfDigit = 0;
        int numOfE = 0;
        int numOfSign = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isValid(c)) {
                return false;
            }
            if (isDigit(c)) {
                numOfDigit++;
            }
            if (isDot(c)) {
                numOfDot++;
                if (numOfDot == 2) {
                    return false;
                }
                if (i == s.length() - 1 && numOfDigit == 0) {
                    return false;
                }
                if (numOfE > 0) {
                    return false;
                }
            }
            if (isE(c)) {
                numOfE++;
                if (numOfE == 2) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (numOfDigit == 0) {
                    return false;
                }
            }
            if (isSign(c)) {
                numOfSign++;
                if (numOfSign == 3) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (i != 0 && numOfE == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return isDigit(c) || isE(c) || isSign(c) || isDot(c);
    }
    
    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    
    private boolean isSign(char c) {
        return c == '-' || c == '+';
    }
    
    private boolean isDot(char c) {
        return c == '.';
    }
}