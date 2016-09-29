public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        boolean isPos = true;
        char c = str.charAt(0);
        if (c == '-' || c == '+') {
            if (c == '-') {
                isPos = false;
            }
            i++;
        }
        
        int num = 0;
        for (; i < str.length(); i++) {
            c = str.charAt(i);
            int n = c - '0';
            if (n < 0 || n > 9) {
                break;
            }
            if (isPos) {
                if (num > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                num *= 10;
                if (num > Integer.MAX_VALUE - n) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (-num < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                num *= 10;
                if (-num < Integer.MIN_VALUE + n) {
                    return Integer.MIN_VALUE;
                }
            }
            num += n;
        }
        
        return isPos ? num : -num;
    }
}