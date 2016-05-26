public class Solution {
  public boolean isPalindrome(String s) {
    s = s.trim().toLowerCase();
    int l = 0;
    int r = s.length() - 1;

    while (l < r) {
      while (l < r && !isAlphabet(s, l)) {
        l++;
      }
      while (l < r && !isAlphabet(s, r)) {
        r--;
      }
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    
    return true;
  }
  
  private boolean isAlphabet(String s, int i) {
    char c = s.charAt(i);
    if ('a' <= c && c <= 'z') {
      return true;
    }
    if ('0' <= c && c <= '9') {
      return true;
    }    
    return false;    
  }
}