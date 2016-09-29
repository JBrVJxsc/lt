public class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] == 0) {
                map[pos] = i + 1;
            } else {
                map[pos] = -1;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] > 0) {
                return map[pos] - 1;
            }
        }
        
        return -1;
    }
}