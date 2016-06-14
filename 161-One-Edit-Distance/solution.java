public class Solution {
  public boolean isOneEditDistance(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();
    
    if (Math.abs(len1 - len2) > 1) {
      return false;
    }
    
    int dif = Math.abs(len1 - len2);
    int i = 0;
    int j = 0;
    int chance = 1;
    
    while (i < len1 && j < len2) {
      if (s1.charAt(i) == s2.charAt(j)) {
        i++;
        j++;
      } else {
        if (len1 < len2) {
          if (chance > 0) {
            chance--;
            j++;
          } else {
            i++;
            j++;
            dif++;
          }
        } else if (len1 > len2) {
          if (chance > 0) {
            chance--;
            i++;
          } else {
            i++;
            j++;
            dif++;
          }          
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