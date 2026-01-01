class Solution {
  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++)
      Arrays.fill(dp[i], -1);

    return dfs(m - 1, n - 1, dp);
  }

  private int dfs(int row, int col, int[][] dp) {
    if (row == 0 && col == 0) // reaches (0,0)
      return 1;

    if (row < 0 || col < 0) // out of bound
      return 0;

    if (dp[row][col] != -1)
      return dp[row][col];

    // if we go from (m,n) to (0,0) then can traverse in 2 directions UP and LEFT
    int upPaths = dfs(row - 1, col, dp);
    int leftPaths = dfs(row, col - 1, dp);

    return dp[row][col] = upPaths + leftPaths;
  }
}