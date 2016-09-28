public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            List<String> list = map.get(temp);
            if (list == null) {
                list = new ArrayList<>();
                map.put(temp, list);
            }
            list.add(str);
        }
        
        for (List<String> list : map.values()) {
            lists.add(list);
        }
        
        return lists;
    }
}