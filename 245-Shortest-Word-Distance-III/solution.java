public class Solution {
    public int shortestWordDistance(String[] words, String w1, String w2) {
        int min = Integer.MAX_VALUE;
        if (w1.equals(w2)) {
            int p = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(w1)) {
                    if (p == -1) {
                        p = i;
                    } else {
                        min = Math.min(min, i - p);
                        p = i;
                    }
                }
            }
        } else {
            int p1 = -1;
            int p2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(w1)) {
                    p1 = i;
                }
                if (words[i].equals(w2)) {
                    p2 = i;
                }     
                if (p1 != -1 && p2 != -1) {
                    min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }
        return min;
    }
}