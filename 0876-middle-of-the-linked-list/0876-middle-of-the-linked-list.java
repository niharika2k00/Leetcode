/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    int len = 1;
    ListNode curr = head;

    while(curr.next != null) {
      len++;
      curr = curr.next;
    }

    int middle = len/2 + 1, i=1;

    while(head.next != null) {
      if (middle == i)
        return head;
      head = head.next;
      i++;
    }
    
    return head;
  }
}