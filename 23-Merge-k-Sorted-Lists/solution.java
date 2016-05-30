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
    
    Queue<ListNode> pq = new PriorityQueue<>((a, b) -> {
      return Integer.compare(a.val, b.val);
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
      next = next.next;
    }
    
    return dummy.next;
  }
}