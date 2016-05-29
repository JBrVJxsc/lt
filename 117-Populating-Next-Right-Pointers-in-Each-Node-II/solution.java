/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    
    Queue<TreeLinkNode> queue = new LinkedList<>();
    queue.add(root);
    Map<TreeLinkNode, Integer> map = new HashMap<>();
    map.put(root, 0);
    
    List<List<TreeLinkNode>> lists = new ArrayList<>();
    while (!queue.isEmpty()) {
      TreeLinkNode node = queue.remove();
      int level = map.get(node);
      if (lists.size() == level) {
        lists.add(new ArrayList<>());
      }
      lists.get(level).add(node);
      
      if (node.left != null) {
        queue.add(node.left);
        map.put(node.left, level + 1);
      }
      if (node.right != null) {
        queue.add(node.right);
        map.put(node.right, level + 1);
      }      
    }
    
    for (List<TreeLinkNode> list : lists) {
      for (int i = 0; i < list.size() - 1; i++) {
        list.get(i).next = list.get(i + 1);
      }
    }
  }
}