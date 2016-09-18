public class Solution {
    public int ladderLength(String begin, String end, Set<String> words) {
        if (begin == null || end == null || words == null || words.size() == 0) {
            return 0;
        }
        words.add(end);
        
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        map.put(begin, 1);
        
        while (!queue.isEmpty()) {
            String node = queue.remove();
            int depth = map.get(node);
            if (node.equals(end)) {
                return depth;
            }
            for (int i = 0; i < node.length(); i++) {
                char[] chars = node.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String temp = String.valueOf(chars);
                    if (map.get(temp) == null && words.contains(temp)) {
                        queue.add(temp);
                        map.put(temp, depth + 1);
                    }
                }
            }
        }
        
        return 0;
    }
}