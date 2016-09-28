public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null && index >= l) {
                l = index + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - l + 1);            
        }
        return max;
    }
}