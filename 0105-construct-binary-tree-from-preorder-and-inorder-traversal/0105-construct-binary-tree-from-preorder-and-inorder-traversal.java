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
  // Note: element at index 0 (first) in PREORDER will be the root of the tree
  int len, idx = 0; // pass by value tracks position in preorder

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    len = preorder.length;

    // storing the value,index in map for easy access
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++)
      map.put(inorder[i], i);

    // TreeNode root = helper(0, len - 1, preorder, inorder);
    TreeNode root = helper(0, len - 1, preorder, inorder, map);

    return root;
  }

  // Method 1: Without using HashMap
  // TC: O(n^2)
  // private TreeNode helper(int start, int end, int[] preorder, int[] inorder) {
  //   // base case if end becomes negative when i=0
  //   if (end < start)
  //     return null;

  //   int i = start, rootNodeValue = preorder[idx];
  //   TreeNode root = new TreeNode(rootNodeValue);
  //   idx++; // now idx points to the next root node

  //   // find the presence of root node in inorder
  //   for (i = start; i <= end; i++) {
  //     if (rootNodeValue == inorder[i])
  //       break;
  //   }

  //   root.left = helper(start, i - 1, preorder, inorder); // recurse on left segment
  //   root.right = helper(i + 1, end, preorder, inorder); // right segment

  //   return root;
  // }

  // Method 2: Using HashMap
  // TC: O(n)  SC: O(n)
  private TreeNode helper(int start, int end, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
    // base case if end becomes negative when i=0
    if (end < start)
      return null;

    int rootNodeValue = preorder[idx];
    TreeNode root = new TreeNode(rootNodeValue);
    idx++; // now idx points to the next root node

    // find the presence of root node in inorder
    int i = map.get(rootNodeValue);

    root.left = helper(start, i - 1, preorder, inorder, map); // recurse on left segment
    root.right = helper(i + 1, end, preorder, inorder, map); // right segment

    return root;
  }
}