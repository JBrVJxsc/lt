/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    return dfs(node, new HashMap<>());
  }
  
  private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
    if (node == null) {
      return null;
    }
    
    UndirectedGraphNode n = map.get(node.label);
    if (n != null) {
      return n;
    } else {
      n = new UndirectedGraphNode(node.label);
      map.put(node.label, n);
    }
    
    for (UndirectedGraphNode neighbor : node.neighbors) {
      n.neighbors.add(dfs(neighbor, map));
    }
    
    return n;
  }
}