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
                sb.append("#");
                if (!queue.isEmpty()) {
                    sb.append("&");
                }
                continue;
            }
            sb.append(node.val);
            sb.append("&");
            queue.add(node.left);
            queue.add(node.right);
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("&");
        if (strs[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < strs.length) {
            TreeNode node = queue.remove();
            String temp = strs[i++];
            if (!temp.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(temp));
                queue.add(node.left);
            }
            temp = strs[i++];
            if (!temp.equals("#")) {
                node.right = new TreeNode(Integer.valueOf(temp));
                queue.add(node.right);
            }            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));