public class Solution {
    public int ladderLength(String begin, String end, Set<String> words) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(begin, 1);
        queue.add(begin);
        words.add(end);
        
        while (!queue.isEmpty()) {
            String str = queue.remove();
            if (str.equals(end)) {
                return map.get(str);
            }
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String temp = String.valueOf(chars);
                    if (map.get(temp) == null && words.contains(temp)) {
                        map.put(temp, map.get(str) + 1);
                        queue.add(temp);
                    }
                }
            }
        }
        
        return 0;
    }
}