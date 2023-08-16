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

// can only be solve with DFS

    int calcSum(TreeNode* root, int currSum){
        if(!root) return 0;
        
        currSum = currSum * 10 + root->val;

        if(!root->left && !root->right) // leaf node
            return currSum;
        
        // int leftSubtreeSum, rightSubtreeSum;
        // if(root->left)
            int leftSubtreeSum = calcSum(root->left, currSum);
        
        // if(root->right)
            int rightSubtreeSum = calcSum(root->right, currSum);

        return leftSubtreeSum + rightSubtreeSum;
    }

    int sumNumbers(TreeNode* root) {
        if(!root) return 0;

        return calcSum(root, 0);
    }
};
