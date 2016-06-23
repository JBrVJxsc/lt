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
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int l = dfs(node.left);
        int r = dfs(node.right);
        int sum = node.val;
        
        if (l > 0 && r > 0) {
            sum += l + r;
        } else if (l > 0 || r > 0) {
            sum += Math.max(l, r);
        }
        
        max = Math.max(max, sum);
        
        if (l > 0 || r > 0) {
            return node.val + Math.max(l, r);
        }
        
        return node.val;
    }
}