class Solution {
  // TC: O(logn)
  // SC: O(1)
  public int search(int[] nums, int target) {
    int len = nums.length;
    int l = 0, r = len - 1, mid;

    while (l <= r) {
      // mid = l + (r - l)/2;
      mid = (l + r) / 2;

      if (nums[mid] == target)
        return mid;

      else if (nums[l] <= nums[mid]) { // for left half
        if (nums[l] <= target && target <= nums[mid])
          r = mid - 1;
        else
          l = mid + 1;
      }

      else { // right half
        if (nums[mid] <= target && target <= nums[r])
          l = mid + 1;
        else
          r = mid - 1;
      }
    }

    return -1;
  }
}