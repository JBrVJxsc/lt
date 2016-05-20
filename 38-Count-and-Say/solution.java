public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        
        for (int i = 1; i < n; i++) {
            str = countAndSay(str);
        }
        
        return str;
    }
    
    private String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char cur = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (cur == str.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(cur);
                count = 1;
                cur = str.charAt(i);
            }
        }
        sb.append(count);
        sb.append(cur);        
        return sb.toString();
    }
}