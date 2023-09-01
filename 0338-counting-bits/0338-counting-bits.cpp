class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> res;

        for(int i=0; i<=n; i++){
            int num=i, count=0;

            while(num > 0){
                count += num % 2; // remainder 5 % 2 = 2
                num = num / 2;
            }

            res.push_back(count);
        }

        return res;
    }
};