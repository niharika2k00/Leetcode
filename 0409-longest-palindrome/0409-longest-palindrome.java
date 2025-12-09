class Solution {
  // TC: O(n), SC: O(n)
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    int len = 0;

    for (char ch : s.toCharArray()) {
      hm.put(ch, hm.getOrDefault(ch, 0) + 1); // store the frequency
    }

    for (int i : hm.values()) {
      if (i % 2 == 0) // if frequency is even then add it otherwise decrease 1 from odd such that it becomes even for palindrome then at the end add 1 for taking one odd
        len += i;
      else
        len += (i - 1);
    }

    return len < s.length() ? len+1 : len;
  }
}