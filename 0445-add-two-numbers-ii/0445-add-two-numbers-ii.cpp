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
class Solution {

    ListNode* reverseList(ListNode* start){
        if(!start || start->next == NULL ){
            return start;
        }

        ListNode* newHead = reverseList(start->next);
        start->next->next = start;
        start->next = NULL;
        return newHead;
    }

    void display(ListNode* start){
        while(start){
            cout << start->val << " ";
            start = start->next;
        }
    }

    ListNode* helper(ListNode* l1, ListNode* l2){
        int carry=0;
        ListNode* res = new ListNode(-1);
        ListNode* curr = res;

        while(l1 || l2 || carry>0){
            int sum=0;
            if(l1){
                sum += l1->val;
                l1 = l1->next;
            }

            if(l2){
                sum += l2->val;
                l2 = l2->next;
            }

            sum += carry;
            int rem = sum % 10; // remainder
            carry = sum / 10; // carry forward

            curr->next = new ListNode(rem); // add new node
            curr = curr->next;
        }


        return res->next;
    }

public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        // display(l1);
        ListNode* res = helper(l1,l2);
        
        return reverseList(res);
    }
};