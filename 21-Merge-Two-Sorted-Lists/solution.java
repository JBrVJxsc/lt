/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                next.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                next.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                next.next = l2;
                l2 = l2.next;
            } else {
                next.next = l1;
                l1 = l1.next;
            }
            next.next.next = null;
            next = next.next;
        }
        
        return dummy.next;
    }
}