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
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, root, 0);
        return lists;
    }
    
    private void dfs(List<List<Integer>> lists, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(node.val);
        dfs(lists, node.left, depth + 1);
        dfs(lists, node.right, depth + 1);
    }
}