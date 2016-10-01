public class Solution {
        public List<List<String>> findLadders(String begin, String end, Set<String> words) {
            Map<String, List<String>> map = new HashMap<>();
            Map<String, Integer> depth = new HashMap<>();
            words.add(begin);
            words.add(end);
            bfs(map, depth, begin, words);

            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add(begin);
            dfs(lists, list, end, map, depth, new ArrayList<>(), 0);
            return lists;
        }

        private void bfs(Map<String, List<String>> map, Map<String, Integer> depth, String begin, Set<String> words) {
            Queue<String> queue = new LinkedList<>();
            queue.add(begin);
            depth.put(begin, 0);
            for (String str : words) {
                map.put(str, new ArrayList<>());
            }

            while (!queue.isEmpty()) {
                String str = queue.remove();
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String temp = String.valueOf(chars);
                        if (!temp.equals(str) && words.contains(temp)) {
                            map.get(str).add(temp);
                            if (depth.get(temp) == null) {
                                depth.put(temp, depth.get(str) + 1);
                                queue.add(temp);
                            }
                        }
                    }
                }
            }
        }

        private void dfs(List<List<String>> lists, List<String> list, String end, Map<String, List<String>> map, Map<String, Integer> depth, List<String> cur, int index) {
            if (cur.size() != 0 && cur.get(cur.size() - 1).equals(end)) {
                lists.add(new ArrayList<>(cur));
                return;
            }
            for (String str : list) {
                if (depth.get(str) == index) {
                    cur.add(str);
                    dfs(lists, map.get(str), end, map, depth, cur, index + 1);
                    cur.remove(cur.size() - 1);
                }
            }
        }
}