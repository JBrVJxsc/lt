public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int pre = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (pre == -1) {
                        pre = i;
                    } else {
                        min = Math.min(min, i - pre);
                        pre = i;
                    }
                }
            }
        } else {
            int i1 = -1;
            int i2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    i1 = i;
                }
                if (words[i].equals(word2)) {
                    i2 = i;
                }
                if (i1 != -1 && i2 != -1) {
                    min = Math.min(min, Math.abs(i1 - i2));
                }
            }
        }
        return min;
    }
}