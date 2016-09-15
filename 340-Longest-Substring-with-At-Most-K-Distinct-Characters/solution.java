public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;        
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (r < s.length() && (map.size() < k || map.size() == k && map.get(s.charAt(r)) != null)) {
                char c = s.charAt(r++);                
                int count = map.getOrDefault(c, 0) + 1;
                map.put(c, count);
            }
            
            max = Math.max(max, r - l);
            
            while (map.size() == k) {
                char c = s.charAt(l++);
                int count = map.get(c) - 1;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            }            
        }
        
        return max;
    }
}