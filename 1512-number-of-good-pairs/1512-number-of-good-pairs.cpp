class Solution {
public:
    int numIdenticalPairs(vector<int>& arr) {
        // number of pairs = n(n -1)/2
        unordered_map <int, int>mp;
        int len = arr.size(), pairs = 0, total=0;
        
        for(int i=0; i<len; i++)
            mp[arr[i]]++;
        
        for(auto it: mp){
            int n = it.second;
            pairs = n*(n-1)/2;
            total += pairs;
        }
        
        return total;
    }
};