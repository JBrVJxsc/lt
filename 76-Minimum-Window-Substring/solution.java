public class Solution {
    public String minWindow(String s, String t) {
          if (s == null || t == null) {
    throw new IllegalArgumentException("s and t cannot be null.");
  }
  
  Map<Character, Integer> map = new HashMap<>();
  for (char c : t.toCharArray()) {
    Integer num = map.getOrDefault(c, 0);
    map.put(c, num + 1);
  }
  
  Map<Character, Integer> found = new HashMap<>();  
  String result = "";
  int l = 0;
  int r = 0;
  int counter = 0;
  int curLen = Integer.MAX_VALUE;

  while (r < s.length()) {
    while (r < s.length() && counter < t.length()) {
      char c = s.charAt(r);
      if (map.get(c) != null) {
        Integer num = found.getOrDefault(c, 0);
        if (num < map.get(c)) {
          counter++;
        }
        found.put(c, num + 1);
      }
      r++;
    }
    
    while (counter == t.length()) {
      char c = s.charAt(l);
      if (map.get(c) != null) {
        Integer num = found.get(c);
        if (num <= map.get(c)) {
          String str = s.substring(l, r);
          if (str.length() < curLen) {
            curLen = str.length();
            result = str;
          }
          counter--;
        }
        found.put(c, num - 1);           
      }
      l++;
    }
  }
  
  return result;
    }
}