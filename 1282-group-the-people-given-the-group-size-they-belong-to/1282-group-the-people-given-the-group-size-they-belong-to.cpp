class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> res;
        int len = groupSizes.size();
        unordered_map<int, vector<int>>mp; // groupsize, index

        for(int i=0; i<len; i++){
            mp[groupSizes[i]].push_back(i); // not insert()
        }

        // print map <int, vector<int>>
        for(auto it: mp){
            cout << it.first << '\t';
            for(auto j: it.second)
                cout << j;
            cout << endl;
        }

        for(auto it=mp.begin(); it!= mp.end(); it++){
            vector<int> vec = it->second;
            int vecLen = vec.size(), grpSize = it->first, idx=0;
            int split = vecLen/grpSize;

            for(int i=0; i<split; i++){
                vector<int> mini;

                for(int j=0; j<grpSize; j++){
                    mini.push_back(vec[idx]);
                    idx++;
                }
                res.push_back(mini);
            }
        }

        return res;
    }
};