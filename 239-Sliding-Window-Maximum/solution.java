public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.remove();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.add(i);
            if (i >= k - 1) {
                result[index++] = nums[q.peek()];
            }
        }
        
        return result;
    }
}