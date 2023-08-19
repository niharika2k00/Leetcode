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
    int xparent=-1, yparent=-1, xdepth=-1, ydepth=-1;

    void helperDFS(TreeNode* root, int x, int y, int depth, int parentVal){        
        if(root->val == x){
            xdepth = depth;
            xparent = parentVal;
            return;
        }

        if(root->val == y){
            ydepth = depth;
            yparent = parentVal;
            return;
        }

        if(root->left)
            helperDFS(root->left, x, y, depth+1, root->val);
        
        if(root->right)
            helperDFS(root->right, x, y, depth+1, root->val);
        
        return;
    }

    bool isCousins(TreeNode* root, int x, int y) {
        if(!root) return false;
        
        helperDFS(root, x, y, 0, -1);

        if(xparent != yparent && xdepth == ydepth)
            return true;
        return false;
    }
};