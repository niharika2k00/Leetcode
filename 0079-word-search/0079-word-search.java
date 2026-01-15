class Solution {
  // Method: Using DFS
  public boolean exist(char[][] board, String word) {

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word.charAt(0)) {
          if (dfs(board, row, col, 0, word))
            return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, int row, int col, int idx, String word) {
    if (idx == word.length())
      return true;

    // handles edge case + out of bound
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '$')
      return false;

    if (board[row][col] != word.charAt(idx))
      return false;

    // store the value for later and mark the cell visited/included
    char temp = board[row][col];
    board[row][col] = '$';

    boolean isFound = dfs(board, row + 1, col, idx + 1, word) || // down
        dfs(board, row - 1, col, idx + 1, word) || // up 
        dfs(board, row, col + 1, idx + 1, word) || // right
        dfs(board, row, col - 1, idx + 1, word); // left

    board[row][col] = temp;
    return isFound;
  }
}