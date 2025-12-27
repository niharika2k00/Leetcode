class Solution {
  Queue<int[]> q = new LinkedList<>();
  int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
  int[][] dist;

  public int[][] updateMatrix(int[][] mat) {
    int row = mat.length, col = mat[0].length;
    dist = new int[row][col];

    if (mat == null || row == 0 || col == 0)
      return new int[0][0];

    // Initialization
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 0) {
          dist[i][j] = 0;
          q.add(new int[] { i, j });
        } else
          dist[i][j] = -1;
      }
    }

    // Multi source BFS
    while (!q.isEmpty()) {
      int[] cell = q.poll(); // removes and return the top element(head)
      int i = cell[0], j = cell[1];

      for (int[] dir : directions) {
        int newi = i + dir[0];
        int newj = j + dir[1];

        // handle boundary and set val where -1
        if (newi >= 0 && newi < row && newj >= 0 && newj < col && dist[newi][newj] == -1) {
          dist[newi][newj] = 1 + dist[i][j];
          q.add(new int[] { newi, newj });
        }
      }
    }

    return dist;
  }
}