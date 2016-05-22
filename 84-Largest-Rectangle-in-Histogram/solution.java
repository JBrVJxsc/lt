public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            h[i] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}