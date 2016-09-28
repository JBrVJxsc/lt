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
        
        int mid = len % 2 == 0 ? len / 2 : len / 2 + 1;
        next = head;
        len = 0;
        
        while (len < mid) {
            len++;
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
    
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        
        while (node.next != null) {
            ListNode next = node.next;
            node.next = node.next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        
        return dummy.next;
    }
}