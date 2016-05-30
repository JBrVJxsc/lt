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
    Stack<TreeNode> stack = new Stack<>();
    load(stack, root);
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      load(stack, node.right);
    }

    return list;
  }
  
  private void load(Stack<TreeNode> stack, TreeNode root) {
    if (root == null) {
      return;
    }
    while (root != null) {
      stack.add(root);
      root = root.left;
    }
  }
}