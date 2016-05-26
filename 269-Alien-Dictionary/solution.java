public class Solution {
  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> in = new HashMap<>();
    Map<Character, Set<Character>> out = new HashMap<>();
    for (String str : words) {
        for (char c : str.toCharArray()) {
            if (in.get(c) == null) {
                in.put(c, new HashSet<>());
            }
            if (out.get(c) == null) {
                out.put(c, new HashSet<>());
            }
        }
    }
    build(in, out, words, 0, words.length - 1, 0);
    return topological(in, out);
  }

  private void build(Map<Character, Set<Character>> in, Map<Character, Set<Character>> out, String[] words, int start, int end, int index) {
    if (start >= end) {
      return;
    }
    
    if (index < words[start].length()) {
      char curChar = words[start].charAt(index);
      int curLen = 1;
      int curIndex = start;
      for (int i = start + 1; i <= end; i++) {
        if (index >= words[i].length()) {
          break;
        }
        char c = words[i].charAt(index);
        if (c != curChar) {
          addEdge(in, out, curChar, c);
          build(in, out, words, curIndex, curIndex + curLen - 1, index + 1);
          curChar = c;
          curLen = 1;
          curIndex = i;
        } else {
          curLen++;
        }
      }
      build(in, out, words, curIndex, curIndex + curLen - 1, index + 1);    
    }
  }
  
  private void addEdge(Map<Character, Set<Character>> in, Map<Character, Set<Character>> out, char head, char tail) {
    in.get(head).add(tail);
    out.get(tail).add(head);
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
      Set<Character> set = out.get(c);
      if (set == null) {
        continue;
      }
      for (char temp : set) {
        in.get(temp).remove(c);
        if (in.get(temp).size() == 0) {
          queue.add(temp);
        }
      }
    }
    
    if (!in.isEmpty()) {
      return "";
    }
    
    return sb.reverse().toString();
  }
}