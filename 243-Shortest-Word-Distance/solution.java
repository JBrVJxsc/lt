public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int l1 = -1;
        int l2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (str.equals(word1)) {
                l1 = i;
            } else if (str.equals(word2)) {
                l2 = i;
            }
            if (l1 != -1 && l2 != -1) {
                min = Math.min(min, Math.abs(l1 - l2));
            }
        }
        
        return min;
    }
}