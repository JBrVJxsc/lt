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
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode pre = root;
        TreeNode preRight = root.right;
        TreeNode cur = root.left;
        
        while (cur != null) {
            TreeNode temp = cur.left;
            cur.left = preRight;
            preRight = cur.right;
            cur.right = pre;
            if (pre == root) {
                pre.left = null;
                pre.right = null;
            }
            pre = cur;
            cur = temp;
        }
        
        return pre;
    }
}