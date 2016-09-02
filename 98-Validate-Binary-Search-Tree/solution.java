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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode node, long lo, long hi) {
        if (node == null) {
            return true;
        }
        if (node.left != null) {
            if (node.val <= node.left.val) {
                return false;
            }
        }
        if (node.right != null) {
            if (node.val >= node.right.val) {
                return false;
            }
        }
        if (node.val <= lo || node.val >= hi) {
            return false;
        }
        return dfs(node.left, lo, node.val) && dfs(node.right, node.val, hi);
    }
    
}

// 1. Check if the value of the node is > left.val && < right.val;
// 2. Check if the value of the node is in the boundery.

