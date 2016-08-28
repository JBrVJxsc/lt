public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 1;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null && index >= start) {
                start = index + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        
        return max;
    }
}