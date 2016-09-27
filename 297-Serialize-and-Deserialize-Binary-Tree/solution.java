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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                sb.append('#');
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (!queue.isEmpty()) {
                sb.append('x');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("x");
        TreeNode root = null;
        if (!strs[0].equals("#")) {
            root = new TreeNode(Integer.valueOf(strs[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (!strs[i++].equals("#")) {
                    node.left = new TreeNode(Integer.valueOf(strs[i - 1]));
                    queue.add(node.left);
                }
                if (!strs[i++].equals("#")) {
                    node.right = new TreeNode(Integer.valueOf(strs[i - 1]));
                    queue.add(node.right);
                }                
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));