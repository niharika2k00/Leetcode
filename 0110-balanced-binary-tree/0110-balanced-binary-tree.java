/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int leftSubtreeHt = helper(root.left);
        int rightSubtreeHt = helper(root.right);

        // Edge Case added. TC: [1,2,2,3,null,null,3,4,null,null,4]
        if(leftSubtreeHt == -1 || rightSubtreeHt == -1)
            return -1;

        if(Math.abs(leftSubtreeHt - rightSubtreeHt) > 1) // check diff between the subtree
            return -1;
        
        return (Math.max(leftSubtreeHt, rightSubtreeHt) + 1); // find height of the subtree
    }

    public boolean isBalanced(TreeNode root) {
        int res = helper(root);
        if(res == -1) return false;
        return true;
    }
}
