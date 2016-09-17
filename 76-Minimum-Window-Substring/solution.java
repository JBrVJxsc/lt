public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> found = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            int count = needs.getOrDefault(c, 0) + 1;
            needs.put(c, count);
        }
        
        int l = 0;
        int r = 0;
        String min = "";
        int count = 0;
        
        while (r < s.length()) {
            while (r < s.length() && count < t.length()) {
                char c = s.charAt(r++);
                if (needs.get(c) != null) {
                    int n = found.getOrDefault(c, 0);
                    if (n < needs.get(c)) {
                        count++;
                    }
                    found.put(c, n + 1);
                }
            }
            
            if (count < t.length()) {
                return min;
            }
            
            while (count == t.length()) {
                char c = s.charAt(l++);
                if (needs.get(c) != null) {
                    int n = found.get(c);
                    if (n == needs.get(c)) {
                        count--;
                        String sub = s.substring(l - 1, r);
                        if (min.length() == 0 || min.length() > sub.length()) {
                            min = sub;
                        }
                    }
                    found.put(c, n - 1);
                }                
            }
        }
        
        return min;
    }
}