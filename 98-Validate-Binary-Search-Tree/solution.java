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
  
  private boolean dfs(TreeNode root, long lower, long upper) {
    if (root == null) {
      return true;
    }
    if (root.val <= lower || root.val >= upper) {
      return false;
    }
    if (!dfs(root.left, lower, root.val)) {
      return false;
    }
    return dfs(root.right, root.val, upper);
  }
}