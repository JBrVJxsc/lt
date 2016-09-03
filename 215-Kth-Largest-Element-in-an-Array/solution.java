public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i : nums) {
            q.add(i);
            if (q.size() > k) {
                q.remove();
            }
        }
        return q.remove();
    }
}