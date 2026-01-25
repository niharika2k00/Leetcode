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
  int level = 1, maxLevelSum = Integer.MIN_VALUE, maxLevel = 0;

  public int maxLevelSum(TreeNode root) {
    // Using BFS (Level Order Traversal)
    bfs(root);
    return maxLevel;
  }

  private void bfs(TreeNode root) {
    if (root == null)
      return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size(), sum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        sum += node.val;

        if (node.left != null)
          q.offer(node.left);

        if (node.right != null)
          q.offer(node.right);
      }

      // computing for each level
      if (sum > maxLevelSum) {
        maxLevelSum = sum;
        maxLevel = level;
      }

      level++;
    }
  }
}