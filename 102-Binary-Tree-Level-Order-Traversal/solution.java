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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    queue.add(root);
    map.put(root, 0);
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      int level = map.get(node);
      if (result.size() == level) {
        result.add(new ArrayList<>());
      }
      result.get(level).add(node.val);
      
      if (node.left != null) {
        queue.add(node.left);
        map.put(node.left, level + 1);
      }
      
      if (node.right != null) {
        queue.add(node.right);
        map.put(node.right, level + 1);
      }
    }
    
    return result;
  }
}