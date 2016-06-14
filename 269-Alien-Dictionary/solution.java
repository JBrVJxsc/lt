public class Solution {
  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> in = new HashMap<>();
    Map<Character, Set<Character>> out = new HashMap<>();
    
    for (String s : words) {
      for (char c : s.toCharArray()) {
        if (in.get(c) == null) {
          in.put(c, new HashSet<>());
        }
        if (out.get(c) == null) {
          out.put(c, new HashSet<>());
        }        
      }
    }
    
    build(words, in, out, 0, 0, words.length - 1);
    return topological(in, out);
  }
  
  private void build(String[] words, Map<Character, Set<Character>> in, Map<Character, Set<Character>> out, int index, int start, int end) {
    while (start <= end && words[start].length() <= index) {
      start++;
    }
    while (start <= end && words[end].length() <= index) {
      end--;
    }    
    
    if (start >= end) {
      return;
    }
    
    char curChar = words[start].charAt(index);
    int curIndex = start;
    for (int i = start + 1; i <= end; i++) {
      char c = words[i].charAt(index);
      if (c != curChar) {
        add(in, out, curChar, c);
        build(words, in, out, index + 1, curIndex, i - 1);
        curIndex = i;
        curChar = c;
      }
    }
    build(words, in, out, index + 1, curIndex, end);
  }
  
  private void add(Map<Character, Set<Character>> in, Map<Character, Set<Character>> out, char c1, char c2) {
    in.get(c1).add(c2);
    out.get(c2).add(c1);
  }
  
  private String topological(Map<Character, Set<Character>> in, Map<Character, Set<Character>> out) {
    Queue<Character> queue = new LinkedList<>();
    for (Map.Entry<Character, Set<Character>> entry : in.entrySet()) {
      if (entry.getValue().size() == 0) {
        queue.add(entry.getKey());
      }
    }
    
    StringBuilder sb = new StringBuilder();
    
    while (!queue.isEmpty()) {
      char c = queue.remove();
      in.remove(c);
      sb.append(c);
      for (char ch : out.get(c)) {
        in.get(ch).remove(c);
        if (in.get(ch).size() == 0) {
          queue.add(ch);
        }
      }
    }
    
    if (in.size() != 0) {
      return "";
    }
    
    return sb.reverse().toString();
  }
}