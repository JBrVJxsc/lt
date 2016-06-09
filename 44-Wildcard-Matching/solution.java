public class Solution {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      throw new IllegalArgumentException("s and p cannot be null.");
    }
    
    int i = 0;
    int j = 0;
    int star = -1;
    int match = 0;
    
    while (i < s.length()) {
      if (i < s.length() && j < p.length() && same(s.charAt(i), p.charAt(j))) {
        i++;
        j++;
      } else if (j < p.length() && p.charAt(j) == '*') {
        star = j;
        j++;
        match = i;
      } else if (star != -1) {
        j = star + 1;
        match++;
        i = match;
      } else {
        return false;
      }
    }
    
    while (j < p.length() && p.charAt(j) == '*') {
      j++;
    }
    
    return j == p.length();
  }
  
  private boolean same(char a, char b) {
    if (a == b || a == '?' || b == '?') {
      return true;
    }
    return false;
  }
}
