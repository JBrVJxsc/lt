public class Solution {
  public boolean isMatch(String str, String pattern) {
    if (str == null || pattern == null) {
      throw new IllegalArgumentException("str or pattern cannot be null.");
    }
    
    if (pattern.length() == 0) {
      return str.length() == 0;
    }
    
    if (pattern.length() == 1 || pattern.charAt(1) != '*') {
      if (str.length() == 0) {
        return false;
      }
      
      if (isSame(str.charAt(0), pattern.charAt(0))) {
        return isMatch(str.substring(1), pattern.substring(1));
      }
      
      return false;
    }
    
    if (pattern.charAt(1) == '*') {
      String sub = pattern.substring(2);
      
      if (isMatch(str, sub)) {
        return true;
      }
      
      int i = 0;
      while (i < str.length() && isSame(str.charAt(i), pattern.charAt(0))) {
        String subStr = str.substring(i + 1);
        if (isMatch(subStr, sub)) {
          return true;
        }
        i++;
      }
      
      return false;
    }
    
    return false;
  }
  
  private boolean isSame(char c1, char c2) {
    if (c1 == c2) {
      return true;
    }
    
    if (c1 == '.' || c2 == '.') {
      return true;
    }
    
    return false;
  }
}