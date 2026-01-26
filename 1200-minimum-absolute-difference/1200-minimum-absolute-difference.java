class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    int len = arr.length, minDiff = Integer.MAX_VALUE;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(arr);

    // find minimum absolute difference
    for (int i = 1; i < len; i++) {
      int diff = Math.abs(arr[i] - arr[i - 1]);
      minDiff = Math.min(minDiff, diff);
    }

    System.out.println(minDiff);

    for (int i = 1; i < len; i++) {
      if (arr[i] - arr[i - 1] == minDiff)
        result.add(Arrays.asList(arr[i - 1], arr[i])); // as a < b => (b - a)
    }

    return result;
  }
}