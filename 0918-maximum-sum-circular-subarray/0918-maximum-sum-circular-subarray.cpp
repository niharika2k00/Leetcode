class Solution {
public:
//  implementation of kadane's algorithm
    int maxSubarraySumCircular(vector<int>& arr) {
        int sum , maxSoFar , maxTotal , minSoFar , minTotal;

         sum = maxSoFar = maxTotal = minSoFar = minTotal = arr[0];
        for(int i = 1; i< arr.size();i++){
            maxSoFar = max(arr[i], maxSoFar + arr[i]);
            maxTotal = max(maxTotal, maxSoFar);
            
            minSoFar = min(arr[i], minSoFar + arr[i]);
            minTotal = min(minTotal, minSoFar);
            sum += arr[i];
        }

        if(sum == minTotal) return maxTotal;
        return max(sum - minTotal, maxTotal);
    }
};