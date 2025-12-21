class Solution {
  public int subarraySum(int[] nums, int k) {
    //  BRUTE - FORCE , Time Complexity : O(n^2)
    /* for (i = 0; i < len; i++) {
        sum = 0;
        for (j = i; j < len; j++) {
            sum = sum + nums[j];
            if (sum == k)
                count++;
        }
    } */

    // OPTIMIZED APPROACH , Time Complexity : O(n)
    HashMap<Integer, Integer> map = new HashMap<>(); // sum -> frequency
    int count = 0, prefixSum = 0;

    // initialize the map with {0 → 1} to handle the case when the subarray starts from index 0
    map.put(0, 1);

    for (int j = 0; j < nums.length; j++) {
      prefixSum += nums[j];

      if (map.containsKey(prefixSum - k)) {
        count += map.get(prefixSum - k);
      }

      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
  }
}
