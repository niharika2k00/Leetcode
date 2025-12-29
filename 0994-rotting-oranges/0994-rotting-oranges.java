class Solution {
  // Using BFS
  public int orangesRotting(int[][] grid) {
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    Queue<int[]> queue = new LinkedList<>();
    int time = -1, freshCount = 0; // in minutes

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 2) // if rotten
          queue.add(new int[] { row, col });
        else if (grid[row][col] == 1)
          freshCount++;
      }
    }

    if (freshCount == 0)
      return 0;
    if (queue.isEmpty())
      return -1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      time++;

      // if using queue.size() directly instead of size, it will not work properly, bcz queue is changeable.
      while (size-- > 0) {
        int[] curr = queue.poll();
        int i = curr[0], j = curr[1];

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
          continue;

        for (int[] dir : directions) { // mark fresh oranges rotten in all 4 directions
          int nx = i + dir[0];
          int ny = j + dir[1];

          if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
            queue.add(new int[] { nx, ny });
            grid[nx][ny] = 2; // mark as visited/rotten
            freshCount--;
          }
        }
      }
    }

    return freshCount != 0 ? -1 : time;
  }
}