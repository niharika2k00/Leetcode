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
    TreeNode* helperDFS(TreeNode* r1, TreeNode* r2){
        // return (!r1 && !r2) ? NULL : (r1 && !r2) ? r1 : r2;

        if (!r1 && !r2) return NULL;
        if (!r1 && r2) return r2;
        if (!r2 && r1) return r1;

        TreeNode* res = new TreeNode(r1->val + r2->val);

        if(r1->left || r2->left)
            res->left = helperDFS(r1->left, r2->left);

        if(r1->right || r2->right)
            res->right = helperDFS(r1->right, r2->right);

        return res;
    }

    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {

        return helperDFS(root1, root2);
    }
};