class Solution {
  public int[][] merge(int[][] intervals) {
    // sort the 2D array
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

    List<int[]> res = new ArrayList<>();
    int[] prev = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= prev[1]){ // start(0-index) of next interval is less than prev end
        prev[1] = Math.max(intervals[i][1], prev[1]); // {[1,4], [2,3]}    
      } else {
        res.add(prev);
        prev = intervals[i]; // storing current interval in prev for next iteration
      }
    }

    res.add(prev);

    return res.toArray(new int[res.size()][]); 
  }
}