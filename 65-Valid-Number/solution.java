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
            if ('0' <= c && c <= '9') {
                numOfDigit++;
            } else if (c == '.') {
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
            } else if (c == 'e' || c == 'E') {
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
            } else if (c == '-' || c == '+') {
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
            } else {
                return false;
            }
        }
        
        return true;
    }
}