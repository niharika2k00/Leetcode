class Solution {
public:
    int minOperations(vector<int>& arr, int x) {
        int len = arr.size(), sum = 0, start=0, subarrSum=0, maxi=-1;
        sum = accumulate(arr.begin(), arr.end(), 0);
        int rem = sum - x;

        if(sum == x) return len;
        if(x > sum) return -1;

        // Find the longest subarray with sum rem
        for(int i=0; i<len; i++){
            subarrSum += arr[i];

            if(subarrSum > rem){
                while(subarrSum > rem){
                    subarrSum = subarrSum - arr[start]; // remove ele from front
                    start++;
                }
            }

            if(subarrSum == rem){
                maxi = max(i-start+1, maxi); // maxLength
            }
        }

        return maxi == -1 ? -1 : len-maxi;
    }
};