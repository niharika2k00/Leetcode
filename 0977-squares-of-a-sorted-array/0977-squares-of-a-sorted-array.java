class Solution {
    public int[] sortedSquares(int[] nums) {
      // Method 1:
      // Square the element in place and then sort it
      // TC: O(nlogn) SC: O(1)

      // Method 2:
      // Using 2 pointer technique
      // TC: O(n) SC: O(n)
      int len=nums.length, left=0, right=len-1;
      int i=len-1;
      int[] res=new int[len];

      for (int k=0; k<len; k++) {
        nums[k] *= nums[k]; // square each element
      }

      while(left <= right) {
        if (nums[right] > nums[left]) { // if right is greater
          res[i--] = nums[right];
          right--;
        }
        else {
          res[i--] = nums[left];
          left++;
        }
      }

      return res;
    }
}