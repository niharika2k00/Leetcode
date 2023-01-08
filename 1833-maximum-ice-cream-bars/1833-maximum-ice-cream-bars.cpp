class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int len = costs.size(), maxIc = 0;

        sort(costs.begin() , costs.end());

        if(costs[0] > coins )
            return 0;

        for(int i = 0 ; i < len ; i++){
            if(costs[i] <= coins){
                coins -= costs[i];
                maxIc ++;
            }
        }

        return maxIc;
    }
};