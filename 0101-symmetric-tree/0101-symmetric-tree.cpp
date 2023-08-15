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
    bool helper(TreeNode* l, TreeNode*r){
        if(!l && !r) // both null
            return true;

        if(!l && r || l && !r)
            return false;
        
        if(l->val == r->val)
            return helper(l->left, r->right) && helper(l->right, r->left);
        
        return false;
    }

    bool isSymmetric(TreeNode* root) {
        if(!root) 
            return true;
        
        bool res = helper(root->left, root->right);
        return res;
    }
};
