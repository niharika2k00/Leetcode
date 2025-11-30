class Solution {
    public int search(int[] nums, int target) {

      // Binary search as the array is already sorted
      int len=nums.length, mid=0;
      int start=0, end=len-1;

      if (len==1 && target!=nums[0]) return -1;

      while(start <= end) {
        mid = (start+end)/2;

        if(nums[mid] == target)
          return mid;
        else if(nums[mid] <= target)
          start = mid + 1;
        else
          end = mid - 1; 
      }

      return -1;  
    }
}