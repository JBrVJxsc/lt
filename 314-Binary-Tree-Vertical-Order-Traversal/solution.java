public class Solution {
  private int min = Integer.MAX_VALUE;
  private int max = Integer.MIN_VALUE;

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }
    
    dfs(root, 0);
    
    int size = max - min + 1;
    List[] temp = new List[size];
    
    Map<TreeNode, Integer> map = new HashMap<>();
    map.put(root, -min);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      int level = map.get(node);
      if (temp[level] == null) {
        temp[level] = new ArrayList<>();
      }
      temp[level].add(node.val);
      
      if (node.left != null) {
        queue.add(node.left);
        map.put(node.left, level - 1);
      }
      
      if (node.right != null) {
        queue.add(node.right);
        map.put(node.right, level + 1);
      }      
    }
    
    for (List list : temp) {
      if (list != null) {
        lists.add(list);
      }
    }
    
    return lists;
  }
  
  private void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    min = Math.min(min, level);
    max = Math.max(max, level);
    dfs(root.left, level - 1);
    dfs(root.right, level + 1);
  }
}

