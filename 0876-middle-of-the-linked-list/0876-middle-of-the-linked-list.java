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
/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode middleNode(ListNode head) {

        // Slow & Fast Pointer Approach
        ListNode slow = head, fast = head;

        while( fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
// @lc code=end

/*
                         METHOD - 1   ::

            Time Complexity : O(n) + O(n/2)

        1)  Loop though the LinkedList , COUNT ++ ,  find the Len ,   (Len / 2  + 1) position.
        2)  Now again iterate and pauses when the Iterator reaches the above position


                          METHOD - 2   ::   *****  OPTIMIZED  *****

            Time Complexity : O(n/2)

        1)  Use 2 Pointer Approach , Hare & Tortoise / Slow & Fast Pointer
        2)  Hare moves +2 steps , and Tortoise moves +1 steps.
*/
