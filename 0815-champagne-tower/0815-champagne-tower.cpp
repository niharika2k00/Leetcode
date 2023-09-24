class Solution {
public:
// Recursive Approach [got TLE]
    double solve(int poured, int i, int j){
        // out of bound conditions
        if(i < 0 || j < 0 || j > i )
            return 0.0;
        
        // target
        if(i == 0 && j == 0)
            return poured;

        double leftGlass = solve(poured, i-1, j-1);
        leftGlass = (leftGlass - 1)/2;
        if(leftGlass < 0) // if negative
            leftGlass = 0;

        double rightGlass = solve(poured, i-1, j);
        rightGlass = (rightGlass - 1)/2;
        if(rightGlass < 0) 
            rightGlass = 0;

        return leftGlass + rightGlass;
    }

// Memoized Approach DP
    double solve(int poured, int i, int j, vector<vector<double>>&dp){
        // out of bound conditions
        if(i < 0 || j < 0 || j > i )
            return 0.0;
        
        // target
        if(i == 0 && j == 0)
            return poured;

        if(dp[i][j] != -1)
            return dp[i][j];

        double leftGlass = solve(poured, i-1, j-1, dp);
        leftGlass = (leftGlass - 1)/2; // take 1 glass for itself then pass if extra
        if(leftGlass < 0) // if negative
            leftGlass = 0;

        double rightGlass = solve(poured, i-1, j, dp);
        rightGlass = (rightGlass - 1)/2;
        if(rightGlass < 0) 
            rightGlass = 0;

        return dp[i][j] = leftGlass + rightGlass;
    }

    double champagneTower(int poured, int query_row, int query_glass) {
        // double res = solve(poured, query_row, query_glass);

        vector<vector<double>> dp(100, vector<double>(100, -1));
        double res = min(1.00, solve(poured, query_row, query_glass, dp)); // 2 varying variables so use dp

        return res;
    }
};