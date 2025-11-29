/*
 * @lc app=leetcode id=92 lang=cpp
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution
{
public:
    ListNode *reverseBetween(ListNode *head, int left, int right)
    {
        ListNode *dummy = new ListNode(NULL);
        ListNode *prev = dummy;
        dummy->next = head;

        // starting position
        for (int i = 0; i < left - 1; i++)
            prev = prev->next;  // Move the prev pointer to the (left - 1)-th node.

        ListNode *curr = prev->next; // The current pointer starts just after the prev.

        while (left++ < right)
        {
            // Reverse the portion.
            ListNode *temp = curr->next;  // save current->next
            curr->next = temp->next; // Update current's next
            temp->next = prev->next; // Insert x node between prev and its next node.
            prev->next = temp; // Update prev's next to point to forward node.
        }

        return head;
    }
};
// @lc code=end
