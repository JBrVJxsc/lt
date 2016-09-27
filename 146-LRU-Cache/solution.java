public class LRUCache {
    class Node {
        int key = -1;
        int val = -1;
        Node pre = null;
        Node next = null;
        
        Node() {
            
        }
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int cap = 0;
    
    public LRUCache(int cap) {
        head.next = tail;
        tail.pre = head;
        this.cap = cap;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void set(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == cap) {
                removeTail();
            }
            node = new Node(key, val);
            map.put(key, node);
        }
        node.val = val;
        moveToHead(node);
    }
    
    private void moveToHead(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    private void removeTail() {
        map.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }
}