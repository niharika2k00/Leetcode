class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int len = temperatures.length;
    int[] result = new int[len];
    Stack<Integer> stack = new Stack<>();

    // Method 1: Brute Force
    // TC: O(n^2) TLE 47/48 testcase passed
    // for (int i = 0; i < len; i++) {
    //   int dayCount = 0;
    //   for (int j = i + 1; j < len; j++) {
    //     dayCount++;
    //     if (temperatures[j] > temperatures[i]) {
    //       result[i] = dayCount;
    //       break;
    //     }
    //   }
    // }

    // Method 2: Using Monotonic Stack
    // TC: O(n)
    for (int i = 0; i < len; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int prevIndex = stack.pop();
        result[prevIndex] = i - prevIndex; // as curr index is greater
      }

      stack.push(i);
    }

    return result;
  }
}
