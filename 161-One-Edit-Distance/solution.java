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
    
    int i = 0;
    int j = 0;
    int dif = 0;
    
    if (len1 == len2) {
      while (i < len1) {
        if (s.charAt(i++) != t.charAt(j++)) {
          dif++;
        }
      }
    } else {
      dif = 1;
      int chance = 1;
      while (i < len1 && j < len2) {
        if (s.charAt(i) != t.charAt(j)) {
          if (chance > 0) {
            chance--;
            if (len1 < len2) {
              j++;
            } else {
              i++;
            }
            continue;
          } else {
            dif++;
          }
        }
        i++;
        j++;
      }
    }
    
    return dif == 1;
  }
}










