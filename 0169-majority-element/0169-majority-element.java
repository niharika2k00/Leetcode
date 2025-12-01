class Solution {
  public int majorityElement(int[] nums) {
    // 🛑 Targeting O(1) space complexity, since HashMap approach is O(n) and its not an optimal approach
    int len = nums.length;

    // Time Complexity  : O(nlogn)
    // Space Complexity : O(1)
    // Method 1
    // Arrays.sort(nums);
    // return nums[len / 2];

    // Time Complexity  : O(n)
    // Space Complexity : O(1)
    // Method 2 - Moore Voting Algorithm
    int count = 0, candidate = 0;

    for (int ele : nums) {
      if (count == 0)
        candidate = ele;

      if (candidate == ele)
        count++;
      else
        count--;
    }

    return candidate;
  }
}