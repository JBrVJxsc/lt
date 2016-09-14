public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        s = s.toLowerCase();
        int len = s.length();
        if (len == 0) {
            return false;
        }
        
        int numOfDigit = 0;
        int numOfE = 0;
        int numOfDot = 0;
        int numOfSign = 0;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (!isValid(c)) {
                return false;
            }
            
            if (isDigit(c)) {
                numOfDigit++;
            }
            
            if (c == '.') {
                numOfDot++;
                if (numOfDot > 1) {
                    return false;
                }
                if (i == len - 1 && numOfDigit == 0) {
                    return false;
                }
                if (numOfE > 0) {
                    return false;
                }
            }
            
            if (c == 'e') {
                numOfE++;
                if (numOfE > 1) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                if (numOfDigit == 0) {
                    return false;
                }
            }
            
            if (isSign(c)) {
                numOfSign++;
                if (numOfSign > 2) {
                    return false;
                }
                if (i == len - 1) {
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
        return c == 'e' || c == '.' || isDigit(c) || isSign(c);
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    
    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
}