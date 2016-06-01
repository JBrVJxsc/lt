public class Solution {
  public int[] findOrder(int num, int[][] pre) {
    Map<Integer, Set<Integer>> in = new HashMap<>();
    Map<Integer, Set<Integer>> out = new HashMap<>();
    build(in, out, num, pre);
    return topo(in, out, num);
  }
  
  private void build(Map<Integer, Set<Integer>> in, Map<Integer, Set<Integer>> out, int num, int[][] pre) {
    for (int i = 0; i < num; i++) {
      in.put(i, new HashSet<>());
      out.put(i, new HashSet<>());
    }
    for (int[] p : pre) {
      in.get(p[0]).add(p[1]);
      out.get(p[1]).add(p[0]);      
    }
  }
  
  private int[] topo(Map<Integer, Set<Integer>> in, Map<Integer, Set<Integer>> out, int num) {
    int[] order = new int[num];
    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Set<Integer>> entry : in.entrySet()) {
      if (entry.getValue().size() == 0) {
        queue.add(entry.getKey());
      }
    }
    int p = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      order[p++] = node;
      in.remove(node);
      for (int i : out.get(node)) {
        in.get(i).remove(node);
        if (in.get(i).size() == 0) {
          queue.add(i);
        }
      }
    }
    if (in.size() != 0) {
      return new int[0];
    }
    return order;
  }
}