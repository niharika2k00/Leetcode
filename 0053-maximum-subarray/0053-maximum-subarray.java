class Solution {
    public int maxSubArray(int[] nums) {
      int currSum=0, maxSum=Integer.MIN_VALUE, len=nums.length, count=0;

      // if all elements of the array is negative then return the min -ve element
      for (int i=0; i<len; i++) {
        currSum += nums[i];
        maxSum = Math.max(currSum, maxSum);

        if (currSum < 0)
          currSum = 0;
      }
      
      return maxSum;
    }
}