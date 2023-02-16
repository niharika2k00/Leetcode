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
    int helper(TreeNode* root){
        int leftsubtree = 0, rightsubtree = 0;
        if(!root)
            return 0;

        if(root->left)
            leftsubtree = helper(root -> left);

        if(root->right)
            rightsubtree = helper(root -> right);
        
        return max(leftsubtree, rightsubtree) + 1;
    }

    int maxDepth(TreeNode* root) {
        if(!root)
            return 0;
        
        return helper(root);
    }
};