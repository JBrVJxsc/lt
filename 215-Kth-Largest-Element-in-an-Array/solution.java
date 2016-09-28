public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.remove();
    }
}