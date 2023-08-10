class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n+1, -1);
        return helper(n, dp);

        // return helper(n);        
    }

/*  int helper(int n){
        int res = INT_MAX;
        if (n <=3 )
            return n;
        
        for (int i=1; i*i <= n; i++){
            int sqNum = i * i;
            int count = 1 + helper(n - sqNum);
            res = min(res, count);
        }

        return res;
    }
*/

    int helper(int n, vector<int> &dp){
        int res = INT_MAX;
        if (n <=3 )
            return n;
        
        if(dp[n] != -1)
            return dp[n];

        for (int i=1; i*i <= n; i++){
            int sqNum = i * i;
            int count = 1 + helper(n - sqNum, dp);
            res = min(res, count);
        }

        return dp[n] = res;
    }
};
