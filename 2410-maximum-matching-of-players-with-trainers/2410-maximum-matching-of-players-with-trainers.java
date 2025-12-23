class Solution {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    // Method: Greedy Approach
    // Time Complexity: O(Nlogn+Mlogm)
    Arrays.sort(players);
    Arrays.sort(trainers);

    int plen = players.length, tlen = trainers.length, count = 0, i = 0, j = 0;

    while (i < plen && j < tlen) {
      if (players[i] <= trainers[j]) {
        count++;
        i++;
        j++;
        continue;
      }
      j++;
    }

    return count;
  }
}