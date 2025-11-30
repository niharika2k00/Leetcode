/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int start=1, end=n, mid=0;

      while(start <= end) {
        //  mid = (start+end)/2;
         mid = start + (end-start)/2;
        if (isBadVersion(mid) && !isBadVersion(mid-1))
          return mid;
        if (!isBadVersion(mid))
          start = mid+1;
        else
          end = mid-1;
      }

      return start;
    }
}