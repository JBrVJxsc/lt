public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> find = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            int count = need.getOrDefault(c, 0) + 1;
            need.put(c, count);
        }
        
        int count = 0;
        int l = 0;
        int r = 0;
        String min = "";
        
        while (r < s.length()) {
            while (r < s.length() && count != t.length()) {
                char c = s.charAt(r++);
                Integer num = need.get(c);
                if (num != null) {
                    int cur = find.getOrDefault(c, 0);
                    if (cur < num) {
                        count++;
                    }
                    find.put(c, cur + 1);
                }
            }
            
            if (count != t.length()) {
                return min;
            }
            
            while (count == t.length()) {
                char c = s.charAt(l++);
                Integer num = need.get(c);
                if (num != null) {
                    int cur = find.get(c);
                    if (cur == num) {
                        count--;
                        String str = s.substring(l - 1, r);
                        if (min.length() == 0 || str.length() < min.length()) {
                            min = str;
                        }
                    }
                    find.put(c, cur - 1);
                }                
            }
        }
        
        return min;
    }
}