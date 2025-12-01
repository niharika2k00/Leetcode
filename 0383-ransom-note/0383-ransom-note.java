class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      HashMap<Character, Integer> hm = new HashMap<>(26);

      for (char i: magazine.toCharArray()) {
        hm.put(i, hm.getOrDefault(i, 0) + 1);
      }

      for (char i: ransomNote.toCharArray()) {
        System.out.println("char: "+ i + " value: "+ hm.get(i));
        // if key available and frequency(value) more than 0, decrement by 1
        if (hm.containsKey(i) && hm.get(i) > 0)
          hm.put(i, hm.get(i) - 1);
        else
          return false;
      }

      return true;
    }
}