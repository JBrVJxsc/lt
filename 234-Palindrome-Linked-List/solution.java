/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        int len = 0;
        ListNode next = head;
        while (next != null) {
            len++;
            next = next.next;
        }
        
        int mid = len - len / 2;
        next = head;
        
        while (mid-- > 0) {
            next = next.next;
        }
        
        next = reverse(next);
        while (next != null) {
            if (next.val != head.val) {
                return false;
            }
            next = next.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) {
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