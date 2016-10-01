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

        void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, Set<String> dict) {
            Queue<String> q = new LinkedList<>();
            q.offer(start);
            distance.put(start, 0);
            for (String s : dict) {
                map.put(s, new ArrayList<>());
            }

            while (!q.isEmpty()) {
                String crt = q.poll();

                List<String> nextList = expand(crt, dict);
                for (String next : nextList) {
                    map.get(next).add(crt);
                    if (!distance.containsKey(next)) {
                        distance.put(next, distance.get(crt) + 1);
                        q.offer(next);
                    }
                }
            }
        }

        List<String> expand(String str, Set<String> dict) {
            List<String> expansion = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    // if (chars[i] == c) {
                    //     continue;
                    // }
                    chars[i] = c;
                    String expanded = String.valueOf(chars);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }

            return expansion;
        }

        void dfs(List<List<String>> ladders, List<String> path, String current, String end, Map<String, Integer> distance, Map<String, List<String>> map) {
            path.add(current);
            if (current.equals(end)) {
                ladders.add(new ArrayList<>(path));
            } else {
                for (String next : map.get(current)) {
                    if (distance.get(current) == distance.get(next) - 1) {
                        dfs(ladders, path, next, end, distance, map);
                    }
                }
            }
            path.remove(path.size() - 1);
        }
}