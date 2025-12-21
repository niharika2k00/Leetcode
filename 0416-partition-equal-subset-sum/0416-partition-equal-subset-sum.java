class Solution {
  public boolean canPartition(int[] nums) {
    int len = nums.length, sum = 0;

    for (int i : nums)
      sum += i;

    // Approach: Check if subset exist with half the total sum
    // Similar to find subarray with sum equal to target
    if (sum % 2 != 0)
      return false; // if odd return false

    int targetSum = sum / 2;
    int dp[][] = new int[len + 1][targetSum + 1];

    // initializing all elements with -1
    for (int i = 0; i < len; i++)
      Arrays.fill(dp[i], -1);

    return helper(nums, len - 1, targetSum, dp);
  }

  private boolean helper(int[] nums, int idx, int targetSum, int[][] dp) {
    boolean res;
    if (idx == 0)
      return nums[0] == targetSum;

    if (targetSum == 0)
      return true;

    if (dp[idx][targetSum] != -1) // use existing value
      return dp[idx][targetSum] == 1;

    if (nums[idx] > targetSum) { // not pick
      res = helper(nums, idx - 1, targetSum, dp); // not returning directly from here as need to typecast from boolean to int for java
    } else {
      boolean consider = helper(nums, idx - 1, targetSum - nums[idx], dp);
      boolean notConsider = helper(nums, idx - 1, targetSum, dp);
      res = consider || notConsider;
    }

    dp[idx][targetSum] = res ? 1 : 0; // storing value as int

    return res;
  }
}

// Note: In Java as using dp array of type int and initializing all elements to -1 by default so need to typecast as helper function returns boolean
// Can also use Boolean wrapper class and set default value to null
