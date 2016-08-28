public class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            result = combine(result, map[c - '0']);
        }
        
        return result;
    }
    
    private List<String> combine(List<String> list, String str) {
        if (list.size() == 0) {
            for (char c : str.toCharArray()) {
                list.add(String.valueOf(c));
            }
            return list;
        } else {
            List<String> temp = new ArrayList<>();
            for (String s : list) {
                for (char c : str.toCharArray()) {
                    temp.add(s + String.valueOf(c));
                }                
            }
            return temp;
        }
    }
}