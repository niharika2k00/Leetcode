class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negatives = 0;
        int smallestNum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                sum += Math.abs(val);
                if (val < 0) negatives++;
                smallestNum = Math.min(smallestNum, Math.abs(val));
            }
        }

        if (negatives % 2 == 0) return sum;
        return sum - 2L * smallestNum;
    }
}