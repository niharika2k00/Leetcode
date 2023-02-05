class Solution {
public:

//      Similar to Longest Increasing Sequence [LIS]    https://leetcode.com/problems/longest-increasing-subsequence/description/
// ---------------------------------------------------------

//  Recursive Method 
    int helper (vector<pair<int,int>>&arr, int len, int i, int prevIdx, vector<vector<int>>&dp){
        int consider = 0, notConsider = 0;
        if(i == len)
            return 0;

        if(dp[i][prevIdx+1] != -1)
            return dp[i][prevIdx+1];    

        notConsider = helper(arr, len, i+1, prevIdx, dp);

        if(prevIdx == -1 || arr[i].second >= arr[prevIdx].second) // means increasing as curr > prev
            consider = arr[i].second + helper(arr, len, i+1, i, dp); // add curr score

        return dp[i][prevIdx+1] = max(consider, notConsider);     
    }

    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        int len = scores.size();
        vector<pair<int,int>>player;
        vector<vector<int>>dp(len, vector<int>(len+1, -1));

        for(int i=0; i<len; i++)
            player.push_back({ages[i], scores[i]});

        sort(player.begin(), player.end());

        return helper(player, len, 0, -1, dp);
        
    }
};