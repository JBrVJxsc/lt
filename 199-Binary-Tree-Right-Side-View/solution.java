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
        dfs(list, root, 0);
        return list;
    }
    
    private void dfs(List<Integer> list, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(node.val);
        }
        dfs(list, node.right, depth + 1);
        dfs(list, node.left, depth + 1);
    }
}