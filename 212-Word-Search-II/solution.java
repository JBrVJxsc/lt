public class Solution {
    
    class Node {
        Node[] nodes = new Node[26];
        String word = null;
    }
    
    private Node root = new Node();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        int row = board.length;
        if (row == 0) {
            return result;
        }
        
        int col = board[0].length;
        if (col == 0) {
            return result;
        }
        
        for (String word : words) {
            build(word);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, root, row, col, result);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, Node node, int row, int col, List<String> result) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '#') {
            return;
        }
        
        int pos = board[i][j] - 'a';
        node = node.nodes[pos];
        
        if (node == null) {
            return;
        } else {
            if (node.word != null) {
                result.add(node.word);
                node.word = null;
            }
        }
        
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(board, i + 1, j, node, row, col, result);
        dfs(board, i - 1, j, node, row, col, result);
        dfs(board, i, j + 1, node, row, col, result);
        dfs(board, i, j - 1, node, row, col, result);
        board[i][j] = temp;
    }
    
    private void build(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int pos = c - 'a';
            if (node.nodes[pos] == null) {
                node.nodes[pos] = new Node();
            }
            node = node.nodes[pos];
        }
        node.word = word;
    }
}