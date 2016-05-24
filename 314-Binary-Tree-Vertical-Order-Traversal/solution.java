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
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        
        getBoundary(root, 0);
        
        int size = max - min + 1;
        List[] temp = new List[size];
        
        // Do BFS.
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, -min);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int level = map.get(node);
            if (temp[level] == null) {
                temp[level] = new ArrayList<>();
            }
            temp[level].add(node.val);
            if (node.left != null) {
                map.put(node.left, level - 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, level + 1);
                queue.add(node.right);
            }
        }
        
        for (List<Integer> list : temp) {
            if (list.size() == 0) {
                continue;
            }
            lists.add(list);
        }
        
        return lists;
    }
    
    private void getBoundary(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        min = Math.min(min, level);
        max = Math.max(max, level);
        getBoundary(root.left, level - 1);
        getBoundary(root.right, level + 1);
    }
}