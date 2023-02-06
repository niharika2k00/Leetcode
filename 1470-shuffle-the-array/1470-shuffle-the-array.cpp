class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        
        vector<int>res(2*n,0);

        for(int i=0; i<n; i++){
            res[2*i] = nums[i];  // 0 -> 0, 2 -> 1, 4 -> 2
            res[2*i + 1] = nums[i+n];
        }

        return res;
    }
};