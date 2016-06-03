public class Solution {
  public String minWindow(String s, String t) {
    if (s == null || t == null) {
      return "";
    }
    
    Map<Character, Integer> dict = new HashMap<>();
    Map<Character, Integer> found = new HashMap<>();
    
    for (char c : t.toCharArray()) {
      int num = dict.getOrDefault(c, 0) + 1;
      dict.put(c, num);
    }
    
    int l = 0;
    int r = 0;
    int counter = 0;
    int curLen = Integer.MAX_VALUE;
    String result = "";
    
    while (r < s.length()) {
      while (r < s.length() && counter != t.length()) {
        char c = s.charAt(r++);
        if (!dict.containsKey(c)) {
          continue;
        }
        int foundNum = found.getOrDefault(c, 0);
        if (foundNum < dict.get(c)) {
          counter++;
        }
        found.put(c, foundNum + 1);
      }
      
      while (l < s.length() && counter == t.length()) {
        char c = s.charAt(l++);
        if (!dict.containsKey(c)) {
          continue;
        }
        int foundNum = found.getOrDefault(c, 0);
        if (foundNum == dict.get(c)) {
          counter--;
          String sub = s.substring(l - 1, r);
          if (sub.length() < curLen) {
            curLen = sub.length();
            result = sub;
          }
        }
        found.put(c, foundNum - 1);
      }
    }
    
    return result;
  }
}