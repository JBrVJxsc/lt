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
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            next.next = node;
            node = node.next;
            if (node != null) {
                queue.add(node);
            }
            next = next.next;
        }
        
        return dummy.next;
    }
}