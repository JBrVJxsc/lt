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
    
    private Node head = new Node(-1, -1);
    private Node bottom = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = bottom;
        bottom.pre = head;
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
        if (capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                removeBottom();
            }
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.val = value;
        }
        moveToHead(node);
    }
    
    private void moveToHead(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        Node next = head.next;
        head.next.pre = node;
        node.next = next;
        head.next = node;
        node.pre = head;
    }
    
    private void removeBottom() {
        map.remove(bottom.pre.key);
        bottom.pre.pre.next = bottom;
        bottom.pre = bottom.pre.pre;
    }
}