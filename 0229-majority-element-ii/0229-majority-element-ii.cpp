class Solution {
public:
    vector<int> majorityElement(vector<int>& arr) {
        int countMajority = arr.size()/3;
        unordered_map<int, int> map;
        vector<int> output;

        for(auto num : arr){
            map[num]++;
        }

        for(auto num : map){
            if(num.second > countMajority){
                output.push_back(num.first);
            }
        }
        
        return output; 
    }
};