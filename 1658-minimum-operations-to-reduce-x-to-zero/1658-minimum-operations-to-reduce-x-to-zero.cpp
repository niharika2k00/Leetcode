class Solution {
public:
    int minOperations(vector<int>& arr, int x) {
        // int len = arr.size(), sum = 0, start=0, subarrSum=0, maxi=-1;
        // sum = accumulate(arr.begin(), arr.end(), 0);
        // int rem = sum - x;

        // if(sum == x) return 0;
        // if(x > sum) return -1;

        // // Find the longest subarray with sum rem
        // for(int i=0; i<len; i++){
        //     subarrSum += arr[i];

        //     // if(subarrSum > rem){
        //         while(subarrSum > rem){
        //             subarrSum -= arr[start]; // remove ele from front
        //             start++;
        //         }
        //     // }

        //     if(subarrSum == rem){
        //         maxi = max(i-start+1, maxi); // maxLength
        //     }
        // }

        // return maxi == -1 ? -1 : len-maxi;

        
        int len = arr.size(), sum = 0, subArrSum = 0, maxLength = -1;
        int i = 0, j = 0;

        sum = accumulate(arr.begin(), arr.end(), 0);

        if (x > sum)
            return -1;
        int remain = sum - x; //  11 - 5 = 6

        // Now we have to find the Longest Subarray with  SUM  = 6
        for (i = 0; i < len; i++)
        {
            subArrSum += arr[i];

            while (subArrSum > remain)
            {
                subArrSum = subArrSum - arr[j]; // delete the first element from the window
                j++;
            }

            if (subArrSum == remain)
                maxLength = max(maxLength, i - j + 1);

        }

        return maxLength == -1 ? -1 : len - maxLength;
    }
};