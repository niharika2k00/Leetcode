class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    // create hashmap for storing frequency
    // add items to priority queue(max heap)
    // pop k elements from top and add to result list

    List<String> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words)
      map.put(word, map.getOrDefault(word, 0) + 1);

    // a and b are two elements from the priority queue that Java is comparing to decide their order.
    // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
      int aCount = map.get(a);
      int bCount = map.get(b);

      if (aCount == bCount)
        return a.compareTo(b); // lexicographically smaller first
      else
        return bCount - aCount;
    });

    // add all keys(words) of the hashmap into priority queue(max heap)
    // maxHeap.addAll(map.keySet());  OR
    for (String word : map.keySet())
      maxHeap.add(word);

    while (k-- > 0)
      result.add(maxHeap.poll());

    return result;
  }
}
