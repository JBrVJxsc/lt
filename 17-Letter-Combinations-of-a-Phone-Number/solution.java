public class Solution {
  
  private String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
  
  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return list;
    }
    
    for (char c : digits.toCharArray()) {
      list = combine(list, map[c - '0']);
    }
    
    return list;
  }

  private List<String> combine(List<String> list, String s) {
    List<String> result = new ArrayList<>();
    if (list.size() == 0) {
      for (char c : s.toCharArray()) {
        result.add(String.valueOf(c));
      }
    } else {
      for (char c : s.toCharArray()) {
        for (String str : list) {
          result.add(str + String.valueOf(c));            
        }
      }      
    }
    return result;
  }
}