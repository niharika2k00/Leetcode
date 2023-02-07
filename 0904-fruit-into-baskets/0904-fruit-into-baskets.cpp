class Solution {
public:
// Similar to find a subarray of max length which has 2 unique numbers
    int totalFruit(vector<int>& fruits) {
        int res = -1, len = fruits.size(), j=0;
        unordered_map<int, int> mp;

        if(len <= 2) return len;

        for(int i=0; i<len ; i++){
            mp[fruits[i]]++;

            if(mp.size() <= 2){
                res = max(res, i-j+1);
            }

            else if(mp.size() > 2){
                mp[fruits[j]]--; // remove front one
                if(mp[fruits[j]] == 0)
                    mp.erase(fruits[j]);
                j++;
            }
        }

        return res;
    }
};