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
 
/* 
  Intuition:
---------------
Use Recursive method BFS - inverse of PreOrder Traversal
Generally we use, Root Left Right but here use Root Right Left instead

*/

class Solution {
    List<Integer> arrli = new ArrayList<Integer>();

    public void helper(TreeNode root, int level){
        if(root == null)
            return;

        if (arrli.size() == level)
            arrli.add(root.val);

        if(root.right != null)
            helper(root.right, level+1);
        if(root.left != null)
            helper(root.left, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
       
        helper(root, 0);
        return arrli;
    }
}