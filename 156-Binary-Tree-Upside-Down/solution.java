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
        
        TreeNode pre = root;
        TreeNode cur = root.left;
        TreeNode preRight = root.right;
        root.left = null;
        root.right = null;
        
        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = preRight;
            preRight = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}