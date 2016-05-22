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
        
        int count = 0;
        ListNode next = head;
        while (next != null) {
            count++;
            next = next.next;
        }
        
        int mid = count / 2;
        next = head;
        int counter = 0;
        while (counter != mid) {
            counter++;
            next = next.next;
        }
        
        if (count % 2 != 0) {
            next = next.next;
        }
        
        next = reverse(next);
        while (next != null) {
            if (head.val != next.val) {
                return false;
            }
            next = next.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        
        return dummy.next;
    }
}