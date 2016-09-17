public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.remove();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.add(i);
            if (i >= k - 1) {
                result[index++] = nums[dq.peek()];
            }
        }
        
        return result;
    }
}