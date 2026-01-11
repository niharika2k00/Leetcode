class Solution {
  public int maxArea(int[] height) {
    int len = height.length, volume = 0, maxVolume = 0;
    int l = 0, r = len - 1;

    while (l < r) {
      // amount of water is the product of the difference between the distance of 2 lines and the height of the minimum line
      volume = (r - l) * Math.min(height[r], height[l]);

      if (height[l] < height[r])
        l++;
      else
        r--;

      maxVolume = Math.max(maxVolume, volume);
    }

    return maxVolume;
  }
}