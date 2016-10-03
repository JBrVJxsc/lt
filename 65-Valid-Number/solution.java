public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        
        s = s.toLowerCase();
        
        int dotNum = 0;
        int digitNum = 0;
        int eNum = 0;
        int signNum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if ('0' <= c && c <= '9') {
                digitNum++;
            } else if (c == '.') {
                if (dotNum == 1) {
                    return false;
                }
                if (i == s.length() - 1 && digitNum == 0) {
                    return false;
                }
                if (eNum != 0) {
                    return false;
                }
                dotNum++;
            }
            else if (c == 'e') {
                if (eNum == 1) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (digitNum == 0) {
                    return false;
                }
                eNum++;
            } else if (c == '+' || c == '-') {
                if (signNum == 2) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (i != 0 && eNum == 0) {
                    return false;
                }
                signNum++;
            } else {
                return false;
            }
        }
        
        return true;
    }
}