public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null) {
      throw new IllegalArgumentException("s and t cannot be null.");
    }
    
    int len1 = s.length();
    int len2 = t.length();
    
    if (Math.abs(len1 - len2) > 1) {
      return false;
    }
    
    if (len1 == 0) {
      return len2 == 1;
    }
    
    if (len2 == 0) {
      return len1 == 1;
    }
    
    int dif = 0;
    if (len1 != len2) {
      dif = 1;
    }
    
    int p1 = 0;
    int p2 = 0;
    int life = 1;
    
    while (p1 < len1 && p2 < len2) {
      if (s.charAt(p1) == t.charAt(p2)) {
        p1++;
        p2++;
        continue;
      } else {
        if (len1 > len2 && life == 1) {
          life--;
          p1++;
        } else if (len1 < len2 && life == 1) {
          life--;
          p2++;
        } else {
          p1++;
          p2++;          
          dif++;
        }
      }
    }
    
    return dif == 1;
  }
}