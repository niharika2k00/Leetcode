class Solution {
  int len;

  public boolean wordBreak(String s, List<String> wordDict) {
    len = s.length();
    Boolean dp[] = new Boolean[len + 1];

    // boolean res = helper(0, s, wordDict);
    boolean res = helper(0, s, wordDict, dp);

    return res;
  }

  // Method 1: Using Recursion (Brute Force)
  // TC: O(2^n) TLE
  private boolean helper(int idx, String s, List<String> wordDict) {
    if (len == idx)
      return true;

    if (wordDict.contains(s)) // if the entire word exist in the array
      return true;

    // check if the substring with length l is present
    for (int end = idx + 1; end <= len; end++) {
      String temp = s.substring(idx, end); // exclusive of end index

      if (wordDict.contains(temp)) // if true then recurse through the rest of the string
        if (helper(end, s, wordDict))
          return true;
    }

    return false;
  }

  // Method 2: Using DP Memoization
  // TC: O(n^2)
  private boolean helper(int idx, String s, List<String> wordDict, Boolean[] dp) {
    if (len == idx)
      return true;

    if (dp[idx] != null)
      return dp[idx];

    if (wordDict.contains(s)) // if the entire word exist in the array
      return true;

    // check if the substring with length l is present
    for (int end = idx + 1; end <= len; end++) {
      String temp = s.substring(idx, end); // exclusive of end index

      if (wordDict.contains(temp)) // if true then recurse through the rest of the string
        if (helper(end, s, wordDict, dp))
          return dp[idx] = true;
    }

    return dp[idx] = false;
  }
}
