class Solution {
  public int singleNumber(int[] nums) {
    // TC: O(n)
    // SC: O(1)
    // Using XOR property a ^ a = 0 || 0 ^ 0 = 0 || a ^ 0 = a
    
    int res=0;
    for (int i = 0; i < nums.length; i++) {
      res = res ^ nums[i];
    }

    return res;
  }
}