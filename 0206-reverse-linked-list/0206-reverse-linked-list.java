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
  public ListNode reverseList(ListNode head) {
    // Method 1: Recursive Approach
    // Ref: https://www.youtube.com/watch?v=KYH83T4q6Vs
    // if (head == null || head.next == null) {
    //   return head;
    // }

    // ListNode revHead = reverseList(head.next);

    // ListNode temp = head.next;
    // temp.next = head;
    // head.next = null;

    // return revHead;

    // Method 2: Iterative Approach
    ListNode curr = head;
    ListNode prev = null;

    while(curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}