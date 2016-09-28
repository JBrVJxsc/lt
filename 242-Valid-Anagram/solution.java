public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char c : t.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                return false;
            }
            map.put(c, --count);
            if (count == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}