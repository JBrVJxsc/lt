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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        invert(node.left);
        invert(node.right);
    }
}