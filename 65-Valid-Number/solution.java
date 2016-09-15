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
        int numOfDot = 0;
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
            
            if (c == 'e') {
                if (numOfE == 1) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                if (numOfDigit == 0) {
                    return false;
                }
                numOfE++;
            }
            
            if (c == '.') {
                if (numOfDot == 1) {
                    return false;
                }
                if (i == len - 1 && numOfDigit == 0) {
                    return false;
                }                
                if (numOfE > 0) {
                    return false;
                }
                numOfDot++;
            }
            
            if (c == '+' || c == '-') {
                if (numOfSign == 2) {
                    return false;
                }
                if (i == len - 1) {
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
        return c == 'e' || isDigit(c) || c == '.' || c == '+' || c == '-';
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}