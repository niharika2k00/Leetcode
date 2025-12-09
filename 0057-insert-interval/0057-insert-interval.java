class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {

    int len=intervals.length, newStart=newInterval[0], newEnd=newInterval[1], i=0;
    List<int[]> res = new ArrayList<>();

    // push element inside the new res till start is MORE than interval end
    while (i < len) {
      if (newStart > intervals[i][1]) // if start is MORE than interval end
        res.add(intervals[i]);
      else if (newEnd < intervals[i][0]) // if end LESS than interval start
        break;
      else {
        // Overlap : merge them
        newStart = Math.min(newStart, intervals[i][0]);
        newEnd = Math.max(newEnd, intervals[i][1]);
      }
      i++;
    }

    res.add(new int[] {newStart,newEnd});

    while (i < len)
      res.add(intervals[i++]);
    
    return res.toArray(new int[res.size()][2]);
  }
}