public class Solution {
  class Node {
    int x = 0;
    int h = 0;
    
    Node(int x, int h) {
      this.x = x;
      this.h = h;
    }
  }
  
  public List<int[]> getSkyline(int[][] buildings) {
    List<Node> nodes = new ArrayList<>();
    for (int[] b : buildings) {
      nodes.add(new Node(b[0], b[2]));
      nodes.add(new Node(b[1], -b[2]));
    }
    
    Collections.sort(nodes, (a, b) -> {
      if (a.x == b.x) {
        return Integer.compare(b.h, a.h);
      } else {
        return Integer.compare(a.x, b.x);
      }
    });
    
    List<int[]> list = new ArrayList<>();
    int height = 0;
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
      return Integer.compare(b, a);
    });
    
    for (Node node: nodes) {
      if (node.h < 0) {
        pq.remove(-node.h);
      } else {
        pq.add(node.h);
      }
      
      if (pq.isEmpty()) {
        list.add(new int[]{node.x, 0});
        continue;
      }
      int h = pq.remove();
      if (h != height) {
        list.add(new int[]{node.x, h});
        height = h;
      }
      pq.add(h);
    }
    
    return list;
  }
}