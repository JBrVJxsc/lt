// Integer:
// 9

// Decimal:
// 9.9  
// 9.
// .9
// Rules:
// 1. Dot cannot be more than 1.
// 2. If dot is the last char, there must be a number before it.

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
// 1. e cannot be more than 1, and e cannot be the last char.
// 2. There should be numbers before e.
// 3. +, - cannot be more than 2, and cannot be the last char.
// 4. If +, - appears in the middle, then there must be an e before it.


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