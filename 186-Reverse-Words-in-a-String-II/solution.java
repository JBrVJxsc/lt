public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int l = 0;
        int r = 0;
        while (r < s.length) {
            while (r < s.length - 1 && s[r + 1] != ' ') {
                r++;
            }
            if (r < s.length) {
                reverse(s, l, r);
                r += 2;
                l = r;
            }
        }
    }
    
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            swap(s, l++, r--);
        }
    }
    
    private void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}