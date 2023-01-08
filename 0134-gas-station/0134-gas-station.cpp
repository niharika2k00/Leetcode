class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {

        int totalGas = 0, currGas = 0, len = gas.size() , station = 0;

        for(int i=0; i<len ; i++){
            totalGas = totalGas + gas[i] - cost[i];
            currGas = currGas + gas[i] - cost[i];

        // If negative
            if(currGas < 0){ 
                currGas = 0;
                station = i+1;
            }
        }

        return totalGas < 0 ? -1 : station;
    }
};
