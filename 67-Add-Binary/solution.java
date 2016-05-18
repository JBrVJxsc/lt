public class Solution {
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int pA = a.length() - 1;
        int pB = b.length() - 1;
        int remain = 0;
        
        while (pA >= 0 || pB >= 0) {
            int numA = pA < 0 ? 0 : a.charAt(pA--) - '0';
            int numB = pB < 0 ? 0 : b.charAt(pB--) - '0';
            remain += numA + numB;
            sb.insert(0, remain % 2);
            remain /= 2;
        }
        
        if (remain == 1) {
            sb.insert(0, 1);
        }
        
        return sb.toString();
    }
}