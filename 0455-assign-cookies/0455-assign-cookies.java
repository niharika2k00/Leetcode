class Solution {
  public int findContentChildren(int[] g, int[] s) {
    // Method: Greedy Approach
    // Time Complexity: ( O(n log n + m log m) ) — for sorting.
    Arrays.sort(g);
    Arrays.sort(s);

    int glen = g.length, slen = s.length;
    int i = 0, j = 0, count = 0;

    // base case
    if (slen == 0)
      return 0;

    while (i < glen && j < slen) {
      if (s[j] >= g[i]) {
        count++;
        j++;
        i++;
        continue;
      }
      j++;
    }

    return count;
  }
}