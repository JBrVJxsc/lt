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
    StringBuilder path = new StringBuilder();
    dfs(root, path, result);
    return result;
  }
  
  private void dfs(TreeNode root, StringBuilder path, List<String> result) {
    if (root == null) {
      return;
    }
    path.append(root.val);
    if (root.left == null && root.right == null) {
      result.add(path.toString());
      return;
    }
    int len = path.length();
    path.append("->");
    dfs(root.left, path, result);
    path.setLength(len);
    
    path.append("->");
    dfs(root.right, path, result);
    path.setLength(len);
  }
}