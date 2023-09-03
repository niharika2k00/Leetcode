class Solution {
public:
    unordered_map<string, int> mp;

// RECURSIVE APPROACH
    // int helper(string s, vector<int>&dp, int idx){
    //     if(idx >= s.size())
    //         return 0;
        
    //     string currStr = "";
    //     int minExtra = s.size(); // considering all the char of the string(max possible value)

    //     for(int i=idx; i<s.size(); i++){
    //         currStr.push_back(s[i]);
           
    //         int currExtra;
    //         if(mp.find(currStr) != mp.end()) currExtra = 0;
    //         else currExtra = currStr.size();

    //         int nextExtra = helper(s, dp, i+1); // next set of recursion

    //         int totalExtra = currExtra + nextExtra;
    //         minExtra = min(minExtra, totalExtra);
    //     }

    //     return minExtra;
    // }


// TOP DOWM - MEMOIZATION APPROACH
    int helper(string &s, vector<int>&dp, int idx){
        if(idx >= s.size())
            return 0;

        if(dp[idx] != -1)
            return dp[idx];
        
        string currStr = "";
        int minExtra = s.size(); // considering all the char of the string(max possible value)

        for(int i=idx; i<s.size(); i++){
            currStr.push_back(s[i]); //currStr will be a string from (index to cutIdx) in backtracking steps
           
            int currExtra;
            if(mp.find(currStr) != mp.end()) currExtra = 0;
            else currExtra = currStr.size();

            int nextExtra = helper(s, dp, i+1); // next set of recursion

            int totalExtra = currExtra + nextExtra;
            minExtra = min(minExtra, totalExtra);
        }

        dp[idx] = minExtra;
        return dp[idx];
    }


    int minExtraChar(string s, vector<string>& dictionary) {
        int n=s.size();
        vector<int>dp(n, -1);

        for(auto it: dictionary)
            mp[it]++;

        int res = helper(s, dp, 0);
        return res;
    }
};