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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    
    Stack<TreeNode> stack = new Stack<>();
    load(stack, root);
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      load(stack, node.right);
    }
    
    return list;
  }

  private void load(Stack<TreeNode> stack, TreeNode node) {
    if (node == null) {
      return;
    }
    
    while (node != null) {
      stack.add(node);
      node = node.left;
    }
  }
}