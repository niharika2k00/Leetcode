class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    // Method: Sliding window
    int slen = s.length(), plen = p.length();
    Map<Character, Integer> stringMap = new HashMap<>();
    Map<Character, Integer> patternMap = new HashMap<>();
    List<Integer> res = new ArrayList<Integer>();

    if (plen > slen)
      return res;

    // add frequency count for k sized window (pattern)
    for (int i = 0; i < plen; i++) {
      stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) + 1);
      patternMap.put(p.charAt(i), patternMap.getOrDefault(p.charAt(i), 0) + 1);
    }

    // add 0 index
    if (stringMap.equals(patternMap))
      res.add(0);

    int start = 0;

    // now start sliding the window
    for (int i = plen; i < slen; i++) {
      // add 1 element to the window and discard 1 from the front
      stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) + 1);
      stringMap.put(s.charAt(start), stringMap.get(s.charAt(start)) - 1);

      // if the frequency of the discarded element is 0
      if (stringMap.get(s.charAt(start)) == 0)
        stringMap.remove(s.charAt(start));

      if (stringMap.equals(patternMap))
        res.add(start+1);

      start++;
    }

    return res;
  }
}
