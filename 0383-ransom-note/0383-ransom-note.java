class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    // Method 1
    HashMap<Character, Integer> hm = new HashMap<>(26);

    for (char i : magazine.toCharArray()) {
      hm.put(i, hm.getOrDefault(i, 0) + 1);
    }

    for (char i : ransomNote.toCharArray()) {
      System.out.println("char: " + i + " value: " + hm.get(i));
      // if key available and frequency(value) more than 0, decrement by 1
      if (hm.containsKey(i) && hm.get(i) > 0)
        hm.put(i, hm.get(i) - 1);
      else
        return false;
    }

    return true;

    // Method 2
    // int[] frequencyArr = new int[26];

    // for (char c : magazine.toCharArray())
    //   frequencyArr[c - 'a']++;

    // for (char c : ransomNote.toCharArray()) {
    //   if (!(frequencyArr[c - 'a'] > 0))
    //     return false;

    //   frequencyArr[c - 'a']--;  
    // }

    // return true;
  }
}