public class Solution {
  public int ladderLength(String begin, String end, Set<String> dict) {
    Map<String, Integer> map = new HashMap<>();
    map.put(begin, 1);
    Queue<String> queue = new LinkedList<>();
    queue.add(begin);
    dict.add(end);
    while (!queue.isEmpty()) {
      String str = queue.remove();
      if (str.equals(end)) {
        return map.get(str);
      }
      for (int i = 0; i < str.length(); i++) {
        char[] chars = str.toCharArray();
        for (int j = 'a'; j <= 'z'; j++) {
          chars[i] = (char)j;
          String change = String.valueOf(chars);
          if (map.containsKey(change)) {
            continue;
          }
          if (dict.contains(change)) {
            queue.add(change);
            map.put(change, map.get(str) + 1);
          }
        }
      }
    }
    return 0;
  }
}