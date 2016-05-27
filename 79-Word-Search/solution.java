public class Solution {
  public boolean exist(char[][] board, String word) {
    if (board == null || word == null) {
      throw new IllegalArgumentException("board and word cannot be null.");
    }
    if (word.length() == 0) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(board, word, new boolean[board.length][board[i].length], i, j, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
    if (index == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return false;
    }
    if (visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }
    visited[row][col] = true;
    
    if (dfs(board, word, visited, row + 1, col, index + 1)) {
      return true;
    }
    if (dfs(board, word, visited, row - 1, col, index + 1)) {
      return true;
    }
    if (dfs(board, word, visited, row, col + 1, index + 1)) {
      return true;
    }
    if (dfs(board, word, visited, row, col - 1, index + 1)) {
      return true;
    }
    
    visited[row][col] = false;
    
    return false;
  }
}