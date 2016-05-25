  

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
    List<String> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    String str = String.valueOf(root.val);
    List<String> left = binaryTreePaths(root.left);
    List<String> right = binaryTreePaths(root.right);
    left.addAll(right);
    if (left.size() == 0) {
      list.add(str);
    } else {
      for (String s : left) {
        list.add(str + "->" + s);
      }
    }
    return list;    
  }
}