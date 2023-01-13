class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        
        int count = 0, len = pref.size();

        for(auto it: words){
            if(it.substr(0,len) == pref)
                count++;
        }

        return count;
    }
};