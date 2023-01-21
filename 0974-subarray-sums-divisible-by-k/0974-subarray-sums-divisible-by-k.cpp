class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int len = nums.size(), res = 0, sum=0, rem=0;

        unordered_map<int, int>hashMap;
        hashMap[0] = 1;

        for(int i=0; i<len ; i++){
            sum += nums[i];
            rem = sum % k;
            if(rem < 0)
                rem += k;
            if(hashMap.find(rem) != hashMap.end()) // found  remainders of arr upto i and arr upto j are equal (ri=rj),
                res += hashMap[rem];

            hashMap[rem]++;    
        }

        return res;
    }
};