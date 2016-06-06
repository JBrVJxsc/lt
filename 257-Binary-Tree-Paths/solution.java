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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    StringBuilder path = new StringBuilder();
    path.append(root.val);
    dfs(root, path, result);
    return result;
  }
  
  private void dfs(TreeNode root, StringBuilder path, List<String> result) {
    if (root.left == null && root.right == null) {
      result.add(path.toString());
      return;
    }
    if (root.left != null) {
      int len = path.length();
      path.append("->");
      path.append(root.left.val);
      dfs(root.left, path, result);
      path.setLength(len);
    }
    if (root.right != null) {
      int len = path.length();
      path.append("->");
      path.append(root.right.val);
      dfs(root.right, path, result);
      path.setLength(len);
    }    
  }
}