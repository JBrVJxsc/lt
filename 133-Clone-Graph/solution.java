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
    if (node == null) {
      return null;
    }
    return clone(node, new HashMap<>());
  }
  
  private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
    if (map.get(node.label) != null) {
      return map.get(node.label);
    }
    
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(copy.label, copy);
    for (UndirectedGraphNode neighbor : node.neighbors) {
      copy.neighbors.add(clone(neighbor, map));
    }
    return copy;
  }
}