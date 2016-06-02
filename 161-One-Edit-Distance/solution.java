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
    
    if (len1 == len2) {
      int dif = 0;
      for (int i = 0; i < len1; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          dif++;
        }
        if (dif > 1) {
          return false;
        }
      }
      return dif == 1;
    } else {
      int chance = 1;
      int i = 0;
      int j = 0;
      while (i < s.length() && j < t.length()) {
        if (s.charAt(i) != t.charAt(j)) {
          chance--;
          if (len1 > len2) {
            i++;
          } else {
            j++;
          }
        } else {
          i++;
          j++;
        }
        if (chance < 0) {
          return false;
        }
      }
      return true;
    }
  }
}

