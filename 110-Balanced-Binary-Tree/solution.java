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
  public boolean isBalanced(TreeNode root) {
    return depth(root, 1) > 0;
  }
  
  private int depth(TreeNode root, int depth) {
    if (root == null) {
      return depth;
    }
    depth += 1;
    int left = depth(root.left, depth);
    if (left < 0) {
      return left;
    }
    int right = depth(root.right, depth);
    if (right < 0) {
      return right;
    }
    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right);
  }
}