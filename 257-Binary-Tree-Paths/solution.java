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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(list, "", root);
        return list;
    }
    
    private void dfs(List<String> list, String cur, TreeNode root) {
        if (root == null) {
            return;
        }
        cur += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(cur);
            return;
        }
        cur += "->";
        dfs(list, cur, root.left);
        dfs(list, cur, root.right);
    }
}