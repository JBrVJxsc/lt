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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }
  
  private TreeNode dfs(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
    if (preS > preE || inS > inE) {
      return null;
    }
    
    TreeNode node = new TreeNode(pre[preS]);
    
    int i = inS;
    while (i <= inE && in[i] != node.val) {
      i++;
    }
    
    node.left = dfs(pre, in, preS + 1, preS + (i - inS), inS, i - 1);
    node.right = dfs(pre, in, preS + (i - inS) + 1, preE, i + 1, inE);
    return node;
  }
}