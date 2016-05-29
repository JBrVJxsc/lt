public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String converted = convert(str);
      List<String> list = map.get(converted);
      if (list == null) {
        list = new ArrayList<>();
        map.put(converted, list);
      }
      list.add(str);
    }
    
    List<List<String>> lists = new ArrayList<>();
    for (List<String> list: map.values()) {
      Collections.sort(list);
      lists.add(list);
    }
    return lists;
  }

  private String convert(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}