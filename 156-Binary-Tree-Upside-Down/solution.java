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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        right.push(null);
        
        while (root != null) {
            left.push(root);
            if (root.left != null) {
                right.push(root.right);
            }
            root = root.left;
        }
        
        TreeNode dummy = new TreeNode(-1);
        TreeNode next = dummy;
        
        while (!left.isEmpty()) {
            next.right = left.pop();
            next.right.left = right.pop();
            next = next.right;
        }
        next.right = null;
        
        return dummy.right;
    }
}