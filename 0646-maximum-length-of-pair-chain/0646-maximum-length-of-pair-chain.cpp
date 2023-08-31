class Solution {
public:
// Similar to https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1 greedy problem

    static bool comp(const vector<int>& vec1, const vector<int>& vec2){
        return vec1[1] < vec2[1];
    }

    int findLongestChain(vector<vector<int>>& pairs) {
        int res=1, lastPairEnd=0;
        sort(pairs.begin(), pairs.end(), comp); // sort the pairs by last element [1]

        // sorted paris
        for(auto it: pairs){
            cout << it[0] << " " << it[1] << endl;
        }

        lastPairEnd = pairs[0][1];

        for(int i=1; i<pairs.size(); i++){
            if(pairs[i][0] > lastPairEnd){
                res++;
                lastPairEnd = pairs[i][1];
            }
        }

        return res;
    }
};
