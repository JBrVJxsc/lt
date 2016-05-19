public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }            
        }
        return pq.remove();
    }
}