public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 2) {
            return true;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            Set<Integer> set = map.get(edge[0]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(edge[1]);
            map.put(edge[0], set);
            
            set = map.get(edge[1]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(edge[0]);
            map.put(edge[1], set);
        }
        
        int count = 1;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            Set<Integer> set = map.get(node);
            if (set == null) {
                return false;
            }
            
            int num = 0;
            for (int i : set) {
                if (visited[i]) {
                    num++;
                } else {
                    count++;
                    queue.add(i);
                    visited[i] = true;
                }
                if (num > 1) {
                    return false;
                }
            }
        }
        
        return count == n;
    }
}