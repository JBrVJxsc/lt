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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return Integer.compare(n1.val, n2.val);
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.remove();
            next.next = node;
            node = node.next;
            if (node != null) {
                pq.add(node);
            }
            next.next.next = null;
            next = next.next;
        }
        return dummy.next;
    }
}