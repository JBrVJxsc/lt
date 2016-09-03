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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode nextA = headA;
        while (nextA != null) {
            lenA++;
            nextA = nextA.next;
        }
        
        int lenB = 0;
        ListNode nextB = headB;
        while (nextB != null) {
            lenB++;
            nextB = nextB.next;
        }
        
        int diff = Math.abs(lenA - lenB);
        nextA = headA;
        nextB = headB;
        
        if (lenA > lenB) {
            while (diff-- > 0) {
                nextA = nextA.next;
            }
        } else if (lenA < lenB) {
            while (diff-- > 0) {
                nextB = nextB.next;
            }            
        }
        
        while (nextA != null) {
            if (nextA == nextB) {
                return nextA;
            }
            nextA = nextA.next;
            nextB = nextB.next;
        }
        
        return null;
    }
}