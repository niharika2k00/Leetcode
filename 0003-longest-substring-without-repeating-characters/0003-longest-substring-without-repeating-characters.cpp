class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int>hashMap;
        int len = s.size(), r = 0, l = 0, res=0;

        for(r=0 ; r<len ; r++){
            hashMap[s[r]]++;

            while(hashMap[s[r]] > 1){
                hashMap[s[l]]--;
                l++;
            }

            res = max(res, r-l+1);
        }

        return res;
    }
};