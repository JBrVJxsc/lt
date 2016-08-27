public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {        
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            String str = queue.remove();
            
            for (int i = 0; i < str.length(); i++) {
                char[] arr = str.toCharArray();
                for (int j = 0; j < 26; j++) {
                    arr[i] = (char)('a' + j);                    
                    String temp = String.valueOf(arr);
                    
                    if (temp.equals(endWord)) {
                        return map.get(str) + 1;
                    }
                    
                    if (!wordList.contains(temp) || map.get(temp) != null) {
                        continue;
                    }
                    
                    map.put(temp, map.get(str) + 1);
                    queue.add(temp);
                }
            }
        }
        
        return 0;
    }
}