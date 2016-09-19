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
        depth(lists, root);
        return lists;
    }
    
    private int depth(List<List<Integer>> lists, TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int depth = depth(lists, root.left);
        depth = Math.max(depth, depth(lists, root.right)) + 1;
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        return depth;
    }
}