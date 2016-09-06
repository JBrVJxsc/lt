public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        
        if (word1.equals(word2)) {
            int pre = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (pre != -1) {
                        min = Math.min(min, Math.abs(pre - i));
                    }
                    pre = i;
                }
            }
        } else {
            int l1 = -1;
            int l2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    l1 = i;
                } else if (words[i].equals(word2)) {
                    l2 = i;
                }
                if (l1 != -1 && l2 != -1) {
                    min = Math.min(min, Math.abs(l1 - l2));
                }
            }
        }
        
        return min;
    }
}