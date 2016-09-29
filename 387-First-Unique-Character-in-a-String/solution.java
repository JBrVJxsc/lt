public class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            map[pos]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (map[pos] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}