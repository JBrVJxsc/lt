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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        while (dummy.left != null) {
            List<Integer> list =  new ArrayList<>();
            dfs(list, dummy);
            lists.add(list);
        }
        
        return lists;
    }
    
    private void dfs(List<Integer> cur, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (isLeaf(root.left)) {
            cur.add(root.left.val);
            root.left = null;
        } else {
            dfs(cur, root.left);
        }
        
        if (isLeaf(root.right)) {
            cur.add(root.right.val);
            root.right = null;
        } else {
            dfs(cur, root.right);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}