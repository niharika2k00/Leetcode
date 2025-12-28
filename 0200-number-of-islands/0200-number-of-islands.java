class Solution {
  // goal is to explore and mark all connected/neighboring land cells (forming an island) using recursive DFS.
  // ----------------
  // Using DFS
  // ----------------
  public int numIslands(char[][] grid) {
    int numberOfIsland = 0;

    if (grid.length == 0)
      return 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          numberOfIsland++;
          dfs(grid, i, j);
        }
      }
    }

    return numberOfIsland;
  }

  private void dfs(char[][] grid, int i, int j) {
    // handle out of bound case
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') // as island is for '1'
      return;

    grid[i][j] = '0'; // replace with anything
    dfs(grid, i + 1, j); // down
    dfs(grid, i - 1, j); // up
    dfs(grid, i, j + 1); // right
    dfs(grid, i, j - 1); // left
  }
}

// ----------------
// Using BFS
// ----------------
public int numIslands(char[][] grid) {
  if (grid.length == 0)
    return 0;

  int numberOfIsland = 0;
  int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  Queue<int[]> queue = new LinkedList<>();

  for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
      if (grid[i][j] == '1') {
        numberOfIsland++;
        queue.add(new int[] { i, j });

        while (!queue.isEmpty()) {
          int[] curr = queue.poll();
          int x = curr[0], y = curr[1];

          if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            continue;
          }

          grid[x][y] = '0'; // mark as visited

          for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1') {
              queue.add(new int[] { nx, ny });
            }
          }
        }
      }
    }
  }

  return numberOfIsland;
}
