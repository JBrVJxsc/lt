public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        
        int col = board[0].length;
        if (col == 0) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, 0, i, j, row, col, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int x, int y, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }        
        
        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) {
            return false;
        }
        
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        
        visited[x][y] = true;        
        if (dfs(board, word, index + 1, x + 1, y, row, col, visited)) {
            return true;
        }        
        if (dfs(board, word, index + 1, x - 1, y, row, col, visited)) {
            return true;
        }        
        if (dfs(board, word, index + 1, x, y + 1, row, col, visited)) {
            return true;
        }        
        if (dfs(board, word, index + 1, x, y - 1, row, col, visited)) {
            return true;
        }                
        visited[x][y] = false;
        
        return false;
    }
}