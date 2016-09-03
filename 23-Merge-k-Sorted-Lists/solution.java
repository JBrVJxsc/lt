/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        
        while (!q.isEmpty()) {
            ListNode node = q.remove();
            next.next = node;
            node = node.next;
            
            if (node != null) {
                q.add(node);
            }
            
            next.next.next = null;
            next = next.next;
        }
        
        return dummy.next;
    }
}