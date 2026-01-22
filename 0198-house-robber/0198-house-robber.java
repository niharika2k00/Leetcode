class Solution {
  int len;

  public int rob(int[] nums) {
    // Method: DP Recursion Memoization Approach (top-down)
    len = nums.length;
    int dp[] = new int[len + 1];
    Arrays.fill(dp, -1);

    return helper(0, nums, dp);
  }

  private int helper(int idx, int[] nums, int[] dp) {
    if (idx >= len)
      return 0;

    if (dp[idx] != -1)
      return dp[idx];

    int include = nums[idx] + helper(idx + 2, nums, dp); // if pick then adjacent element not possible (i+2)
    int exclude = helper(idx + 1, nums, dp); // if not pick then move to the next element (i+1)

    dp[idx] = Math.max(include, exclude);
    return dp[idx];
  }
}

/*
Dry Run: [20,5,5,10]

helper(0)
├── include: 20 + helper(2)
│   └── helper(2)
│       ├── include: 5 + helper(4)
│       │   └── helper(4) = 0   (out of bounds)
│       └── exclude: helper(3)
│           └── helper(3)
│               ├── include: 10 + helper(5)
│               │   └── helper(5) = 0
│               └── exclude: helper(4) = 0
│               => helper(3) = max(10, 0) = 10
│       => helper(2) = max(5+0, 10) = 10
└── exclude: helper(1)
    └── helper(1)
        ├── include: 5 + helper(3)
        │   └── helper(3) = 10
        └── exclude: helper(2)
            └── helper(2) = 10
        => helper(1) = max(5+10, 10) = 15

=> helper(0) = max(20+10, 15) = 30
*/
