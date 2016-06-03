public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> dict = new HashMap<>();
    for (char c : t.toCharArray()) {
      int num = dict.getOrDefault(c, 0) + 1;
      dict.put(c, num);
    }
    
    Map<Character, Integer> found = new HashMap<>();
    int l = 0;
    int r = 0;
    int count = 0;
    int curLen = Integer.MAX_VALUE;
    String result = "";
    
    while (r < s.length()) {
      while (r < s.length() && count != t.length()) {
        char c = s.charAt(r++);
        if (dict.get(c) != null) {
          Integer foundNum = found.getOrDefault(c, 0);
          if (foundNum < dict.get(c)) {
            count++;
          }
          found.put(c, foundNum + 1);
        }
      }
      
      while (count == t.length()) {
        char c = s.charAt(l++);
        if (dict.get(c) != null) {
          int foundNum = found.get(c);
          if (foundNum == dict.get(c)) {
            count--;
            String str = s.substring(l - 1, r);
            if (str.length() < curLen) {
              curLen = str.length();
              result = str;
            }
          }
          found.put(c, foundNum - 1);
        }        
      }
    }
    return result;
  }
}