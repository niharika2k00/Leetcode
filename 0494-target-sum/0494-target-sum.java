class Solution {
  private int sum;

  public int findTargetSumWays(int[] nums, int target) {
    int len = nums.length;

    // NOTE: As target can be negative here,so target can't be use as size. Need to shift the range.
    // Ex: lets say the nums = [2,3,1,4]
    // now calculate the extremes total sum is 10 if all element is +ve and -10 if all -ve
    // Hence, range [-10, 10] and -10 index not posible so need to shift the range, need to add +10.
    // Resultant [0, 20], So take the size of the dp array by adding the sum with the target.

    for (int i : nums)
      sum += i;

    int[][] dp = new int[len + 1][2 * sum + 1]; // due to range shift
    for (int i = 0; i < len; i++)
      Arrays.fill(dp[i], -1);

    int res = helper(nums, len - 1, target, 0, dp);
    // int res = helper(nums, len - 1, target, 0);
    return res;
  }

  // Method 1: Recursion
  // TC: O(2^n)
  private int helper(int[] nums, int idx, int target, int currentSum) {
    if (idx < 0)
      return currentSum == target ? 1 : 0;

    int subtract = helper(nums, idx - 1, target, currentSum - nums[idx]);
    int add = helper(nums, idx - 1, target, currentSum + nums[idx]);

    return subtract + add;
  }

  // Method 2: Memoization (with range shift)
  // TC: O(n*totalsum)
  private int helper(int[] nums, int idx, int target, int currentSum, int[][] dp) {
    // base case
    if (idx < 0)
      return currentSum == target ? 1 : 0;

    if (dp[idx][sum + currentSum] != -1)
      return dp[idx][sum + currentSum];

    int add, subtract;
    add = helper(nums, idx - 1, target, currentSum + nums[idx], dp);
    subtract = helper(nums, idx - 1, target, currentSum - nums[idx], dp);

    return dp[idx][sum + currentSum] = add + subtract;
  }
}
