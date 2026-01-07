class Solution {
  public int[] plusOne(int[] digits) {
    // Method 1
    // Getting wrong ans for large TC need to handle in java otherwise follow method 2
    // long len = digits.length, num = 0;

    // for (int i = 0; i < len; i++)
    //   num = num * 10 + digits[i];
    // num = num + 1;

    // String s = String.valueOf(num);
    // int[] res = new int[s.length()];

    // for (int i = 0; i < s.length(); i++)
    //   res[i] = s.charAt(i) - '0'; // 52 - 48 = 4 as ASCII value of 4 is '52'

    // return res;

    // Method 2
    int len = digits.length;

    // if digit less than 9 then only increase by 1 in-place
    // All other cases will be handled here - 470, 489, 499
    for (int i = len - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    
    // only for cases like 99, 999 where it becomes 10, 100.
    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }
}