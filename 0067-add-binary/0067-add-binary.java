class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    StringBuilder res = new StringBuilder();
    int carry = 0;

    while (i>=0 || j>=0 || carry==1) {
      int sum = carry;

      if(i>=0) sum += a.charAt(i--) - '0';
      if(j>=0) sum += b.charAt(j--) - '0';

      res.append(sum % 2);
      carry = sum / 2;
    }

    return res.reverse().toString();
  }
} 

// 1 + 0 = 0
// 0 + 1 = 0
// 0 + 0 = 0
// 1 + 1 = 10
