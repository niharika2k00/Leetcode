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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if (list1 == null && list2 == null) return list1;
    if (list1 == null || list2 == null) return (list1 != null) ? list1 : list2;

    ListNode dummy = new ListNode(-1); // new dummy node
    ListNode newStart=dummy, p1=list1, p2=list2; // new p1 and p2 are pointers pointing to head of LL

    while (p1 != null && p2 != null) { // either != null
      if (p1.val <= p2.val) {
        dummy.next = p1;
        p1 = p1.next;
      } else {
        dummy.next = p2;
        p2 = p2.next;
      }

      dummy = dummy.next;
    }

    // when one list is not fully iterated
    if (p1 != null)
      dummy.next = p1;
    else
      dummy.next = p2;

    return newStart.next;
  }
}
/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        {
            ListNode dummy = new ListNode(-1); // (-1) default value in the Newly Allocated / Created NODE.
            ListNode newStart = dummy; // variable

            // Base Case
            if (list1 == null && list2 == null)
                return list1; // null

            // if(!list1 || !list2) return list1 ? list1 : list2;
            if (list1 == null)
                return list2;

            if (list2 == null)
                return list1;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    dummy.next = list1;
                    list1 = list1.next;
                }

                else if (list1.val > list2.val) {
                    dummy.next = list2;
                    list2 = list2.next;
                }

                dummy = dummy.next; // dummy also shifts
            }

            // Now if only 1 List remaining , means if List1 NOT FULLY TRAVERSED
            if (list1 != null)
                dummy.next = list1;
            if (list2 != null)
                dummy.next = list2;

            return newStart.next;
        }
    }
}
// @lc code=end

