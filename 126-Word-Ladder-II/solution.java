public class Solution {
        public List<List<String>> findLadders(String start, String end,
                                              Set<String> dict) {
            List<List<String>> ladders = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            Map<String, Integer> distance = new HashMap<>();

            dict.add(start);
            dict.add(end);

            bfs(map, distance, start, dict);

            List<String> path = new ArrayList<>();

            dfs(ladders, path, start, end, distance, map);

            return ladders;
        }

        void bfs(Map<String, List<String>> map, Map<String, Integer> depth, String begin, Set<String> words) {
            Queue<String> queue = new LinkedList<>();
            queue.add(begin);
            depth.put(begin, 0);

            while (!queue.isEmpty()) {
                String str = queue.remove();
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String temp = String.valueOf(chars);
                        if (!temp.equals(str) && words.contains(temp)) {
                            if (map.get(str) == null) {
                                map.put(str, new ArrayList<>());
                            }
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

        void dfs(List<List<String>> ladders, List<String> path, String current, String end, Map<String, Integer> distance, Map<String, List<String>> map) {
            path.add(current);
            if (current.equals(end)) {
                ladders.add(new ArrayList<>(path));
            } else {
                if (map.get(current) != null) {
                    for (String next : map.get(current)) {
                        if (distance.get(current) == distance.get(next) - 1) {
                            dfs(ladders, path, next, end, distance, map);
                        }
                    }
                }
            }
            path.remove(path.size() - 1);
        }
}