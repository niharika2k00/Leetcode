class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    StringBuilder ans = new StringBuilder();
    int carry = 0;

    // loop untill reaches 0 index and no carry-over value left
    while (i >= 0 || j >= 0 || carry == 1) {
      int sum = carry;

      if (i >= 0) {
        sum += a.charAt(i) - '0'; // converts char to int, 1 - 0 equals to 49 - 48 || 48 - 48
        i--;
      }

      if (j >= 0) {
        sum += b.charAt(j) - '0';
        j--;
      }

      ans.append(sum % 2); // mod with 2 as its binary
      carry = sum / 2;
    }

    return ans.reverse().toString();
  }
}

// 0 + 0 = 0
// 1 + 0 = 1
// 0 + 1 = 1
// 1 + 1 = 10
