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
  
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    dfs(root, 1);
    return max;
  }
  
  private void dfs(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      max = Math.max(max, depth);
    }
    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
  }
}