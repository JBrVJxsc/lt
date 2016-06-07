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
    // public List<List<Integer>> convert(TreeNode root) {
        
    // }
    
  private int min = Integer.MAX_VALUE;
  private int max = Integer.MIN_VALUE;
  
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    
    dfs(root, 0);
    int size = max - min + 1;
    
    for (int i = 0; i < size; i++) {
      result.add(new ArrayList<>());
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    Map<TreeNode, Integer> col = new HashMap<>();
    queue.add(root);
    col.put(root, -min);
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      int colNum = col.get(node);
      result.get(colNum).add(node.val);
      if (node.left != null) {
        queue.add(node.left);
        col.put(node.left, colNum - 1);
      }
      if (node.right != null) {
        queue.add(node.right);
        col.put(node.right, colNum + 1);
      }      
    }
    
    return result;
  }
  
  private void dfs(TreeNode root, int col) {
    if (root == null) {
      return;
    }
    
    min = Math.min(min, col);
    max = Math.max(max, col);
    
    dfs(root.left, col - 1);
    dfs(root.right, col + 1);
  }    
}