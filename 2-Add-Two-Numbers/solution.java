/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        int remain = 0;
        
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                remain += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                remain += l2.val;
                l2 = l2.next;
            }
            next.next = new ListNode(remain % 10);
            remain /= 10;
            next = next.next;
        }
        
        if (remain == 1) {
            next.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}