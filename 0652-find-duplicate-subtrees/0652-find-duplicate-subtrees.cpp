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
/*
    Intuition : 
    Create the subtree string and store into a hashMap.
    Next time check whether newly created string is present inside the hashMap or not.
    If yes then push it into a vector.
*/
    string getSubtreeString(TreeNode* root, unordered_map<string,int> &mp, vector<TreeNode*> &res) {
        if(!root)
            return "N";
        
        string str = to_string(root->val) + "," + getSubtreeString(root->left, mp, res) + "," + getSubtreeString(root->right, mp, res);
        cout << str << endl;

        if(mp.find(str) != mp.end()){
            if(mp[str] == 1) // means already encountered
                res.push_back(root);
        }

        mp[str]++;
        return str;
    }

    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        unordered_map<string, int> mp;
        vector<TreeNode*> res;

        getSubtreeString(root, mp, res);
        return res;
    }
};