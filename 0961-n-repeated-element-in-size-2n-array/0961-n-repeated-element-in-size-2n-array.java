class Solution {
  public int repeatedNTimes(int[] nums) {
    int len = nums.length;
    int n = len / 2;

    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < len; i++) {
      hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

      if (hm.get(nums[i]) == n)
        return nums[i];
    }

    return nums[len-1];
  }
}