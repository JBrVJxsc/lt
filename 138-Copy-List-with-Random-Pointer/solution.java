/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode next = head;
        while (next != null) {
            RandomListNode temp = next.next;
            next.next = new RandomListNode(next.label);
            next.next.next = temp;
            next = temp;
        }
        
        next = head;
        while (next != null) {
            if (next.random != null) {
                next.next.random = next.random.next;
            }
            next = next.next.next;
        }
        
        RandomListNode dummy = new RandomListNode(-1);
        next = dummy;
        
        while (head != null) {
            next.next = head.next;
            head.next = head.next.next;
            head = head.next;
            next = next.next;
        }
        
        return dummy.next;
    }
}