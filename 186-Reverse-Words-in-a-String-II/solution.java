public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int l = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                continue;
            }
            reverse(s, l, i - 1);
            l = i + 1;
        }
        reverse(s, l, s.length - 1);
    }
  
    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            swap(chars, l++, r--);
        }
    }
    
    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}