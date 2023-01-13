class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        int len = nums.size(), sum =0 ;
        unordered_set<int> set;

        for(int i=0 ; i<len-1 ; i++){
            sum = nums[i] + nums[i+1];

            if(set.find(sum) == set.end()) // not found
                set.insert(sum);
            else {
                cout << "Sum = " << sum;
                return true;
            }
        }

        return false;
    }
    
    
    
    // Method 2 : Using HashMap.
};
