class Solution {
  // goal is to explore and mark all connected/neighboring land cells (forming an island) using recursive DFS.
  // Using DFS
  public int numIslands(char[][] grid) {
    int len = grid.length, numberOfIsland = 0;

    if (len == 0)
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