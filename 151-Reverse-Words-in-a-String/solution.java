public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            String str = strs[i];
            if (str.length() > 0) {
                sb.append(str);
                sb.append(" ");
            }            
        }
        return sb.toString().trim();
    }
}