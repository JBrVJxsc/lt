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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 0);
        for (int i = 1; i < lists.size(); i += 2) {
            reverse(lists.get(i));
        }
        return lists;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> lists, int depth) {
        if (node == null) {
            return;
        }
        if (depth == lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(node.val);
        dfs(node.left, lists, depth + 1);
        dfs(node.right, lists, depth + 1);
    }
    
    private void reverse(List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            swap(list, l++, r--);
        }
    }
    
    private void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}