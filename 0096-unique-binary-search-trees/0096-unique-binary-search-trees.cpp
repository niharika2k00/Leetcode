class Solution {
public:
    int helper(int n, vector<int> &dp) {
        for(int i=2; i<=n; i++){
            dp[i] = 0;
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-1-j];  // C2 = C0C1 + C1C0
            }
        }

        return dp[n];
    }

    int numTrees(int n) {
        vector<int> dp(n+1, 0);
        dp[0]= 1;
        dp[1]= 1;
        return helper(n, dp);
    }
};