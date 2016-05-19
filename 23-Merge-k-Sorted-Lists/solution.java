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
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode a = merge(lists, start, mid);
        ListNode b = merge(lists, mid + 1, end);
        return merge(a, b);
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        
        while (a != null || b != null) {
            if (a == null) {
                next.next = b;
                b = b.next;
            } else if (b == null) {
                next.next = a;
                a = a.next;
            } else if (a.val > b.val) {
                next.next = b;
                b = b.next;
            } else {
                next.next = a;
                a = a.next;
            }
            next.next.next = null;
            next = next.next;
        }
        
        return dummy.next;
    }
}