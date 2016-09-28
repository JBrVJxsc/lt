/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return null;
        }
        
        int pLen = 0;
        ListNode next = p;
        while (next != null) {
            pLen++;
            next = next.next;
        }
        
        int qLen = 0;
        next = q;
        while (next != null) {
            qLen++;
            next = next.next;
        }
        
        while (pLen > qLen) {
            p = p.next;
            pLen--;
        }
        
        while (pLen < qLen) {
            q = q.next;
            qLen--;
        }
        
        while (p != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        
        return null;
    }
}