public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> found = new HashMap<>();
    
    for (char c : t.toCharArray()) {
      int num = needs.getOrDefault(c, 0) + 1;
      needs.put(c, num);
    }
    
    int l = 0;
    int r = 0;
    int count = 0;
    String min = "";
    
    while (r < s.length()) {
      while (r < s.length() && count < t.length()) {
        char c = s.charAt(r++);
        if (needs.get(c) == null) {
            continue;
        }
        int num = found.getOrDefault(c, 0);
        if (num < needs.get(c)) {
          count++;
        }
        found.put(c, ++num);
      }
      
      while (l < s.length() && count == t.length()) {
        char c = s.charAt(l++);
        if (needs.get(c) == null) {
            continue;
        }        
        int num = found.get(c);
        if (num == needs.get(c)) {
          count--;
          String sub = s.substring(l - 1, r);
          if (min.length() == 0 || sub.length() < min.length()) {
            min = sub;
          }
        }
        found.put(c, --num);
      }      
    }
    
    return min;
  }
}