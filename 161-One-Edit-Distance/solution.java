public class Solution {
  public boolean isOneEditDistance(String s1, String s2) {
    int dif = Math.abs(s1.length() - s2.length());
    int i = 0;
    int j = 0;
    int chance = 1;
    
    while (i < s1.length() && j < s2.length()) {
      if (s1.charAt(i) == s2.charAt(j)) {
        i++;
        j++;
      } else {
        if (s1.length() < s2.length() && chance > 0) {
          chance--;
          j++;
        } else if (s1.length() > s2.length() && chance > 0) {
          chance--;
          i++;
        } else {
          i++;
          j++;
          dif++;
        }
      }
    }
    
    return dif == 1;
  }
}