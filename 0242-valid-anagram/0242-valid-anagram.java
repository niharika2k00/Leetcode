class Solution {
    public boolean isAnagram(String s, String t) {
      int slen=s.length(), tlen=t.length();
      HashMap<Character, Integer> hashMap = new HashMap<>(26); // number of alphabets
      // int[] alpha = new int[26]; can also be done using array of size 26

      if (slen != tlen) return false;

      // calculate frequency
      for(char i: s.toCharArray()){
        hashMap.put(i, hashMap.getOrDefault(i, 0) + 1); // getOrDefault(Object key, V defaultValue)
      }

      for(char i: t.toCharArray()){
        hashMap.put(i, hashMap.getOrDefault(i, 0) - 1);
      }

      // Check no keys present
      // here hashMap.isEmpty() won't work as the keys are not removed, only their values set to 0
      for (int val: hashMap.values()) {
        if (val != 0)
          return false;
      }
      
      return true;
    }
}

// Time complexity: O(n)
// Space complexity: O(1) as fixed size array/map
