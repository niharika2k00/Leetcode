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
  List<Integer> result = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    // Using BFS (Level Order Traversal)
    bfs(root);

    return result;
  }

  private void bfs(TreeNode root) {
    if (root == null)
      return;

    Queue<TreeNode> q = new LinkedList();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      TreeNode node = null;

      for (int i = 0; i < size; i++) {
        node = q.poll();

        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
      }

      result.add(node.val); // push the last node for every level into the array
    }
  }
}