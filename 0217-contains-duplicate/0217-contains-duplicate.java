class Solution {
  public boolean containsDuplicate(int[] nums) {
    // Time Complexity: O(nlogn)
    // Arrays.sort(nums);
    // for (int i = 1; i < nums.length; i++) {
    //   if (nums[i - 1] == nums[i])
    //     return true;
    // }

    // Time Complexity: O(n)
    HashSet<Integer> hm = new HashSet<>();
    for (int num : nums) {
      if (hm.contains(num))
        return true;
      hm.add(num);
    }

    return false;
  }
}