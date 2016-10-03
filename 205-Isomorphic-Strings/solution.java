public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        char[] dic1 = new char[256];
        char[] dic2 = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (dic1[c1] == 0) {
                dic1[c1] = c2;
            } else if (dic1[c1] != c2) {
                return false;
            }
            if (dic2[c2] == 0) {
                dic2[c2] = c1;
            } else if (dic2[c2] != c1) {
                return false;
            }            
        }
        
        return true;
    }
}