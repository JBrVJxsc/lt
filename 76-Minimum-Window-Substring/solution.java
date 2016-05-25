public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      int num = map.getOrDefault(c, 0) + 1;
      map.put(c, num);
    }
    
    Map<Character, Integer> found = new HashMap<>();
    String result = "";
    int l = 0;
    int r = 0;
    int counter = 0;
    int curLen = Integer.MAX_VALUE;
    
    while (r < s.length()) {
      while (r < s.length() && counter != t.length()) {
        char c = s.charAt(r++);
        if (map.get(c) != null) {
          int num = found.getOrDefault(c, 0);
          if (num < map.get(c)) {
            counter++;
          }
          found.put(c, num + 1);
        }
      }
      
      while (counter == t.length()) {
        char c = s.charAt(l++);
        if (map.get(c) != null) {
          int num = found.get(c);
          if (num == map.get(c)) {
            counter--;
            String str = s.substring(l - 1, r);
            if (str.length() < curLen) {
              curLen = str.length();
              result = str;
            }
          }
          found.put(c, num - 1);
        }
      }
    }
    
    return result;
  }
}