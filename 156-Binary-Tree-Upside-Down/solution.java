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
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        
        Stack<TreeNode> l = new Stack<>();
        Stack<TreeNode> r = new Stack<>();
        
        while (root != null) {
            l.push(root);
            r.push(root.right);
            root = root.left;
        }
        r.pop();
        
        root = l.pop();
        TreeNode next = root;
        
        while (!l.isEmpty()) {
            next.left = r.pop();
            next.right = l.pop();
            next = next.right;
            next.left = null;
            next.right = null;
        }
        
        return root;
    }
}