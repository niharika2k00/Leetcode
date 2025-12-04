class Solution {
    public int missingNumber(int[] nums) {
      // we can sort it directly and check with the index, but this is O(nlogn) not the optimised one. 
      // So target a solution using only O(1) extra space complexity and O(n) runtime complexity.

      int len=nums.length, res=0;
      for (int i=0; i<len; i++) {
        res = res ^ nums[i] ^ i;
      }

      return res ^ len;
    }
}