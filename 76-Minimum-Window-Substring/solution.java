public class Solution {
  public String minWindow(String s, String t) {
    if (s == null || t == null) {
      throw new IllegalArgumentException("s and t cannot be null.");
    }
    
    if (t.length() > s.length()) {
      return "";
    }
    
    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> found = new HashMap<>();
    
    for (char c : t.toCharArray()) {
      int num = needs.getOrDefault(c, 0) + 1;
      needs.put(c, num);
    }
    
    String result = "";
    int counter = 0;
    int l = 0;
    int r = 0;
    while (r < s.length()) {
      while (r < s.length() && counter != t.length()) {
        char c = s.charAt(r++);
        if (!needs.containsKey(c)) {
          continue;
        }
        int num = found.getOrDefault(c, 0);
        if (num < needs.get(c)) {
          counter++;
        }
        found.put(c, num + 1);
      }
      
      while (l < s.length() && counter == t.length()) {
        char c = s.charAt(l++);
        if (!needs.containsKey(c)) {
          continue;
        }
        int num = found.get(c);
        if (num == needs.get(c)) {
          counter--;
          String sub = s.substring(l - 1, r);
          if (result.equals("") || sub.length() < result.length()) {
            result = sub;
          }
        }
        found.put(c, num - 1);        
      }
    }
    
    return result;
  }
}