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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode, Integer> level = new HashMap<>();
        level.put(root, 1);        
        int preLevel = 1;
        int preValue = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int l = level.get(node);
            if (l != preLevel) {
                list.add(preValue);
            }
            preLevel = l;
            preValue = node.val;
            if (node.left != null) {
                queue.add(node.left);
                level.put(node.left, l + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                level.put(node.right, l + 1);
            }
        }
        list.add(preValue);
        
        return list;
    }
}