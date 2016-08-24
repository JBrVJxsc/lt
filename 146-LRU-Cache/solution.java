public class LRUCache {

    class Node {
        int key;
        int val;
        Node next = null;
        Node prev = null;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
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
        if (cap <= 0) {
            return;
        }
        
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == cap) {
                removeTail();
            }
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.val = value;
        }
        moveToHead(node);
    }
    
    private void moveToHead(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private void removeTail() {
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}