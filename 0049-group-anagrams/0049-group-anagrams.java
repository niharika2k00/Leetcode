class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    int len = strs.length;
    HashMap<String, List<String>> map = new HashMap<>();

    // step 1: sort each string from the list
    // step 2: store sorted string as key and original string as value in the hashmap
    for (int i = 0; i < len; i++) {
      char[] item = strs[i].toCharArray();
      Arrays.sort(item);
      String sortedWord = new String(item);

      // if key not present in hashmap, then newly add it
      if (!map.containsKey(sortedWord))
        map.put(sortedWord, new ArrayList<>());

      map.get(sortedWord).add(strs[i]);
    }

    for (List<String> value : map.values())
      result.add(value);

    return result;
  }
}

// Sort each string and store in the hashmap
// "eat"   →   "aet"
// "tea"   →   "aet"
// "tan"   →   "ant"
// "ate"   →   "aet"
// "nat"   →   "ant"
// "bat"   →   "abt"

// HashMap view :
// "aet": ["eat", "tea", "ate"] 
// "ant": ["tan", "nat"]
// "bat": ["abt"]
