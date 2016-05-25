public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("s and t cannot be null.");
        }
        
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer n = target.getOrDefault(c, 0);
            target.put(c, n + 1);
        }
        
        Map<Character, Integer> found = new HashMap<>();
        int curL = 0;
        int curR = 0;
        int count = 0;
        int curLen = Integer.MAX_VALUE;
        String result = "";
        
        while (curR < s.length()) {
            while (curR < s.length() && count < t.length()) {
                char c = s.charAt(curR);
                Integer n = target.get(c);
                if (n != null) {
                    Integer f = found.getOrDefault(c, 0);
                    if (f < n) {
                        count++;
                    }
                    found.put(c, f + 1);                    
                }
                curR++;
            }
            
            while (count == t.length()) {
                char c = s.charAt(curL);
                Integer n = target.get(c);
                if (n != null) {
                    Integer f = found.getOrDefault(c, 0);
                    if (f <= n) {
                        String str = s.substring(curL, curR);
                        if (str.length() < curLen) {
                            curLen = str.length();
                            result = str;
                        }
                        count--;                        
                    }
                    found.put(c, f - 1);
                }
                curL++;
            }
        }
        
        return result;
    }
}