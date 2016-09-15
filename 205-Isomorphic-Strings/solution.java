public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }        
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] map1 = new char[256];
        char[] map2 = new char[256];
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (map1[c1] != 0 && map1[c1] != c2) {
                return false;
            }
            
            if (map2[c2] != 0 && map2[c2] != c1) {
                return false;
            }            
            
            map1[c1] = c2;
            map2[c2] = c1;
        }
        
        return true;
    }
}