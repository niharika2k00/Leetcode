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
  // Method 1
  // public ListNode middleNode(ListNode head) {
  //   int len = 1;
  //   int middle = len / 2 + 1, i = 1;
  //   ListNode curr = head;

  //   while (curr.next != null) {
  //     len++;
  //     curr = curr.next;
  //   }

  //   while (head.next != null) {
  //     if (middle == i)
  //       return head;
  //     head = head.next;
  //     i++;
  //   }

  //   return head;
  // }

  // Method 2 (Slow and fast pointer)
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}