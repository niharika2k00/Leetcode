class Solution {
  public void moveZeroes(int[] nums) {
    // Note that you must do this in-place without making a copy of the array. Maintain SC: O(1)
    int zeropointer = 0;
    
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[zeropointer];
        nums[zeropointer] = nums[i];
        nums[i] = temp;
        zeropointer++;
      }
    }
  }
}