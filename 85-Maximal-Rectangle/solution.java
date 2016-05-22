public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < m[0].length; i++) {
            if (matrix[0][i] == '1') {
                m[0][i] = 1;
            }
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (matrix[i][j] == '1') {
                    m[i][j] = m[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        
        for (int i = 0; i < m.length; i++) {
            max = Math.max(max, max(m[i]));
        }
        
        return max;
    }
    
    private int max(int[] heights) {
        int[] h = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            h[i] = heights[i];
        }
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < h.length) {
            if (s.isEmpty() || h[s.peek()] <= h[i]) {
                s.push(i++);
            } else {
                int top = s.pop();
                int area = h[top] * (s.isEmpty() ? i : i - s.peek() - 1);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}