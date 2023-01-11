/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // Check Level Order Traversal
        
        if(!p && !q) return true;
        if(!p || !q || p->val != q->val) return false;

        queue<TreeNode*> queue1;
        queue<TreeNode*> queue2;

        queue1.push(p);
        queue2.push(q);
        
        while(!queue1.empty() && !queue2.empty()) {
            TreeNode* front1 = queue1.front();
            TreeNode* front2 = queue2.front();

            // result.push_back(front->val);
            queue1.pop();
            queue2.pop();

            // (front1 && !front2) check is not needed as its present in the queue means node present
            if(front1->val != front2->val)
                return false;
            
            if(front1->left && front2->left){
                queue1.push(front1->left);
                queue2.push(front2->left);
            }
            else if(front1->left != NULL || front2->left != NULL) return false;

            if(front1->right && front2->right){
                queue1.push(front1->right);
                queue2.push(front2->right);
            }
            else if(front1->right != NULL || front2->right != NULL) return false;
        }

        return true;
    }
};




//    Recursive Method
// ----------------------
    bool isSameTree(TreeNode* p, TreeNode* q) {
     
        if(!p && !q) return true;
        if(!p || !q || p->val != q->val) return false;
        return (p->val == q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }

