/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root, 0) != -1;
    }
    
    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        
        int l = dfs(node.left, depth + 1);
        if (l < 0) {
            return l;
        }
        
        int r = dfs(node.right, depth + 1);
        if (r < 0) {
            return r;
        }
        
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        
        return Math.max(l, r);
    }
}