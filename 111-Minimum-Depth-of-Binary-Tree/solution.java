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
  
  int min = Integer.MAX_VALUE;
  
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    dfs(root, 1);
    return min;
  }
  
  private void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      min = Math.min(min, level);
    }
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }
}