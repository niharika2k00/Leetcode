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
  int count = 1, res = 0;

  public int kthSmallest(TreeNode root, int k) {
    // as this is a BST so INORDER TRAVERSAL gives sorted order
    inorderTraversal(root, k);
    return res;
  }

  private void inorderTraversal(TreeNode root, int k) {
    if (root == null)
      return;

    inorderTraversal(root.left, k);
    if (count == k)
      res = root.val;

    count++;
    System.out.println(root.val);
    inorderTraversal(root.right, k);
  }
}