class Solution {
    // Recustion (Top Down Approach)
    // Complexity : Time: O(2^n) ; Space: O(n)
    // public int climbStairs(int n) {
    //   if (n == 0) return 0;
    //   if (n == 1) return 1;
    //   if (n == 2) return 2;

    //   return climbStairs(n-1) + climbStairs(n-2);
    // }

    // DP (Bottom Up Approach)
    // Complexity : Time: O(n) ; Space: O(n)
    public int climbStairs(int n) {
      if (n <= 1) return 1;
      
      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;

      for (int i = 3; i <= n; i++) {
          dp[i] = dp[i - 1] + dp[i - 2];
      }

      return dp[n];
    }
}
