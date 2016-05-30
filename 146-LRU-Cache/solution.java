public class LRUCache {
  
  class Node {
    Node pre = null;
    Node next = null;
    int key = 0;
    int val = 0;
    
    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
  
  private Map<Integer, Node> map = new HashMap<>();
  private Node head = new Node(-1, -1);
  private Node tail = new Node(-1, -1);
  private int cap = 0;
  
  public LRUCache(int capacity) {
    cap = capacity;
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.val;
  }

  public void set(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      if (cap == map.size()) {
        removeTail();
      }
      node = new Node(key, value);
      map.put(key, node);
    }
    node.val = value;
    moveToHead(node);
  }
  
  private void moveToHead(Node node) {
    if (node.next != null) {
      node.next.pre = node.pre;
    }
    if (node.pre != null) {
      node.pre.next = node.next;
    }
    node.next = head.next;
    head.next.pre = node;
    head.next = node;
    node.pre = head;
  }
  
  private void removeTail() {
    map.remove(tail.pre.key);
    tail.pre.pre.next = tail;
    tail.pre = tail.pre.pre;
  }
}