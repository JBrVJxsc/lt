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
    if (root == null) {
      return new ArrayList<>();
    }
    if (root.left == null && root.right == null) {
      List<String> list = new ArrayList<>();
      list.add(String.valueOf(root.val));
      return list;
    }
    List<String> result = new ArrayList<>();
    List<String> list = binaryTreePaths(root.left);
    for (String str : list) {
      result.add(String.valueOf(root.val) + "->" + str);
    }
    list = binaryTreePaths(root.right);
    for (String str : list) {
      result.add(String.valueOf(root.val) + "->" + str);
    }
    return result;
  }
}