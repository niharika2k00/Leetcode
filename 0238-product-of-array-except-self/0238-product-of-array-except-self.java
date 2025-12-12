class Solution {
  public int[] productExceptSelf(int[] nums) {
    // Method: Using PrefixSum
    int len=nums.length;
    int[] suffixProd = new int[len];
    int[] prefixProd = new int[len];
    int[] res = new int[len];

    prefixProd[0] = 1;
    for(int i=1; i<len; i++)
      prefixProd[i] = prefixProd[i-1] * nums[i-1];
    
    suffixProd[len - 1] = 1;
    for(int i=len-2; i>=0; i--)
      suffixProd[i] = suffixProd[i+1] * nums[i+1];

    for(int i=0; i<len; i++)
      res[i] = prefixProd[i] * suffixProd[i];
      
    return res;
  }
}