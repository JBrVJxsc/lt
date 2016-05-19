/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        while (head.next != null) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        
        return dummy.next;
    }
}