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
    if (head == null) {
      return true;
    }
    
    int count = 0;
    ListNode next = head;
    while (next != null) {
      count++;
      next = next.next;
    }
    
    int mid = count / 2;
    mid += count % 2;
    
    int counter = 1;
    next = head;
    
    while (counter != mid) {
      counter++;
      next = next.next;
    }
    
    ListNode reversed = reverse(next.next);
    
    while (reversed != null) {
      if (reversed.val != head.val) {
        return false;
      }
      reversed = reversed.next;
      head = head.next;
    }
    
    return true;
  }
  
  private ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
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