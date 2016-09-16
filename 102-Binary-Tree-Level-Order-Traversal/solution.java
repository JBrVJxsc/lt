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
    
    private void dfs(List<List<Integer>> lists, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        dfs(lists, root.left, depth + 1);
        dfs(lists, root.right, depth + 1);
    }
}