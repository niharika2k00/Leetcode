class Solution {
  static int max_value = Integer.MAX_VALUE/2; // this is taken due to overflow issue 
  // Integer.MAX_VALUE = 2147483647
  // 2147483647 + 1 = -2147483648   (WRONG, overflows to negative!)

  public int coinChange(int[] coins, int amount) {
    int len = coins.length;

    int[][] dp = new int[len + 1][amount + 1];
    for (int i = 0; i < len; i++)
      Arrays.fill(dp[i], -1);

    int res = helper(coins, len - 1, amount, dp);
    return res == max_value ? -1 : res;
  }

  private int helper(int[] coins, int idx, int target, int[][] dp) {
    if (target == 0)
      return 0;

    if (idx == 0) {
      if (target % coins[0] == 0) {
        return target / coins[0]; // use coin[0] this many times
      } else {
        return max_value; // impossible with just this coin
      }
    }

    if (dp[idx][target] != -1)
      return dp[idx][target];

    int take = max_value, notTake;
    notTake = helper(coins, idx - 1, target, dp);

    if (coins[idx] <= target) {
      take = 1 + helper(coins, idx, target - coins[idx], dp);
    }

    return dp[idx][target] = Math.min(take, notTake);
  }
}
