class Solution {
public:
    int path(int m, int n, vector<vector<int>>&dp){
        if(m==0 || n==0) 
            return 1;

        if(dp[m][n]!=-1)
            return dp[m][n];
            
        return dp[m][n]=path(m-1,n,dp) + path(m,n-1,dp); // right + down
    }

    int uniquePaths(int m, int n) {
        vector<vector<int>>dp(m,vector<int>(n,-1));
        return path(m-1,n-1,dp); 
    }
};