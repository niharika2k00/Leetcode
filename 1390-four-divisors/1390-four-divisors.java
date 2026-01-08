class Solution {
  public int sumFourDivisors(int[] nums) {
    int len = nums.length, count = 0, result = 0, divisorsSum =0;

    for (int i = 0; i < len; i++) {
      int num = nums[i];
      count = 0;
      divisorsSum = 0;

      // finding all its divisors
      for (int j = 1; j <= Math.sqrt(num); j++) {
        if (num % j == 0) {
          if (num / j == j) { // if divisors equal add only once 
            count++;
            divisorsSum += j;
          } else {
            count += 2;
            divisorsSum += j;
            divisorsSum += num / j;
          }
        }

        if (count > 4)
          break;
      }

      if (count == 4)
        result += divisorsSum;
    }

    return result;
  }
}