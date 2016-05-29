/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    StringBuilder sb = new StringBuilder();
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (node == null) {
        sb.append('*').append('#');
        continue;
      }
      sb.append(node.val).append('#');
      queue.add(node.left);
      queue.add(node.right);
    }
    
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("*#")) {
      return null;
    }
    
    String[] strs = data.split("#");
    TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
    int pos = 1;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (pos == strs.length) {
        break;
      }
      String val = strs[pos++];
      if (!val.equals("*")) {
        node.left = new TreeNode(Integer.valueOf(val));
        queue.add(node.left);
      }
      val = strs[pos++];
      if (!val.equals("*")) {
        node.right = new TreeNode(Integer.valueOf(val));
        queue.add(node.right);
      }
    }
    
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));