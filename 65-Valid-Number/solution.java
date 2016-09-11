// Integer:
// 9

// Decimal:
// 9.9  
// 9.
// .9

// Signed:
// +(Integer)
// -(Integer)
// +(Decimal)
// -(Decimal)

// Unsigned:
// Integer
// Decimal

// Exponential:
// (Signed)e(Integer)
// (Signed)e+(Integer)
// (Signed)e-(Integer)
// (Unsigned)e(Integer)
// (Unsigned)e+(Integer)
// (Unsigned)e-(Integer)

// Rules:
// 1. Dot cannot be more than 1.
// 2. If dot is the last char, then there must be a digit before it.
// 3. Dot cannot be after the e.
// 4. e cannot be more than 1.
// 5. e cannot be the last char.
// 6. There must be digit before e.
// 7. +, - cannot be more than 2.
// 8. +, - cannot be the last char.
// 9. If +, - is in the middle of the str, then there must be a e before it.

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
        
        int signCount = 0;
        int eCount = 0;
        int digitCount = 0;
        int dotCount = 0;
        
        // Do check.
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (!isValid(c)) {
                return false;
            }
            
            if (isDigit(c)) {
                digitCount++;
            }
            
            if (c == '.') {
                if (dotCount == 1) {
                    return false;
                }
                if (i == len - 1 && digitCount == 0) {
                    return false;
                }
                if (eCount > 0) {
                    return false;
                }
                dotCount++;
            }            
            
            if (c == 'e') {
                if (eCount == 1) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                if (digitCount == 0) {
                    return false;
                }
                eCount++;
            }
            
            if (isSign(c)) {
                if (signCount == 2) {
                    return false;
                }
                if (i == len - 1) {
                    return false;
                }
                if (i != 0 && eCount == 0) {
                    return false;
                }
                signCount++;
            }            
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return c == '.' || c == 'e' || isDigit(c) || isSign(c);
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
    
    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
}