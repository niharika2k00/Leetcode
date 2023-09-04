class Solution {
public:
    int path(int i, int j, int m, int n, vector<vector<int>>&dp){
        // as zero index
        if(i == m-1 && j == n-1) { 
            cout << i << " " << j << endl;
            return 1;
        }

        if(i >= m || j >= n) // boundary exceeds
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
            
        return dp[i][j] = path(i+1, j, m, n, dp) + path(i, j+1, m, n, dp); // right + down
    }

    int uniquePaths(int m, int n) {
        vector<vector<int>>dp(m,vector<int>(n,-1));
        return path(0, 0, m, n, dp); 
    }
};
