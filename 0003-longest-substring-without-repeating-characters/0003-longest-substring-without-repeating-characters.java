class Solution {
  public int lengthOfLongestSubstring(String s) {
    // Method 1: Sliding Window and Hashing
    // TC: O(n) SC: O(1)
    if (s.equals("") || s.isEmpty()) return 0;

    int left = 0, right = 0, maxWindowLength = -1;
    HashMap<Character, Integer> hm = new HashMap<>(); // char,frequency

    for (right = 0; right < s.length(); right++) {
      char ele = s.charAt(right);
      hm.put(ele, hm.getOrDefault(ele, 0) + 1);

      int frequency = hm.get(ele);
      if (frequency > 1) {
        while (hm.get(ele) > 1) {
          char leftChar = s.charAt(left);
          hm.put(leftChar, hm.get(leftChar) - 1); // shrink the window
          left++;
        }
      }

      maxWindowLength = Math.max(maxWindowLength, right - left + 1);
    }

    return maxWindowLength;
  }
}