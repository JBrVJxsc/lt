public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<String>> map = new HashMap<>();            
        
        for (String str : strs) {
            String cvt = convert(str);
            List<String> list = map.get(cvt);
            if (list == null) {
                list = new ArrayList<>();
                map.put(cvt, list);
            }
            list.add(str);
        }
        
        for (List<String> list : map.values()) {
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