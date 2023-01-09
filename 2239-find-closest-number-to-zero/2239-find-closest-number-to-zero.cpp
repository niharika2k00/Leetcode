class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        int len = nums.size(), diff = 0;
        map<int,int> mp; // <diff,num>

        sort(nums.begin() , nums.end());

        for(int i=0 ; i < len; i++){
            diff = abs(nums[i]);
            mp[diff] = nums[i];  // when same diff(key), overwrite with the latest one.
        }

        return mp.begin()->second;
    }
};