public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] heights = new int[row][col];
    
    for (int i = 0; i < col; i++) {
      heights[0][i] = matrix[0][i] - '0';
    }
    
    for (int i = 1; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
          heights[i][j] = heights[i - 1][j] + 1;
        }
      }
    }
    
    int max = 0;
    for (int i = 0; i < row; i++) {
      max = Math.max(max, max(heights[i]));
    }
    
    return max;
  }
  
  private int max(int[] h) {
    int max = 0;
    int[] heights = new int[h.length + 1];
    for (int i = 0; i < h.length; i++) {
      heights[i] = h[i];
    }
      
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    while (i < heights.length) {
      if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
        stack.push(i++);
      } else {
        int height = heights[stack.pop()];
        int len = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, height * len);
      }
    }
    
    return max;
  }
}