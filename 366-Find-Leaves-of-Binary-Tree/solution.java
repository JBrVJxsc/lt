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
        height(lists, root);
        return lists;
    }
    
    private int height(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int h = Math.max(height(list, root.left), height(list, root.right));
        
        if (list.size() == h) {
            list.add(new ArrayList<>());
        }
        list.get(h).add(root.val);
        
        return h + 1;
    }
}