public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.getValue(), b.getValue());
        });
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(entry);
            if (q.size() > k) {
                q.remove();
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            list.add(q.remove().getKey());
        }
        return list;
    }
}