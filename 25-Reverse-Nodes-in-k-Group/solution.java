public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k < 2) {
      return head;
    }
    
    int len = 0;
    ListNode next = head;
    while (next != null) {
      len++;
      next = next.next;
    }
    
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    
    int group = len / k;
    for (int i = 0; i < group; i++) {
      for (int j = 1; j < k; j++) {
        next = head.next;
        head.next = head.next.next;
        next.next = pre.next;
        pre.next = next;
      }
      pre = head;
      head = pre.next;
    }
    
    return dummy.next;
  }
}