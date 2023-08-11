class Solution {
public:
    bool search(vector<int>& arr, int target) {
        int len=arr.size(), mid;
        int low=0, high=len-1;

        while(low <= high){
            mid = low + (high - low)/2;

            if(arr[mid] == target)
                return true;

            else if (arr[low] == arr[mid] && arr[mid] == arr[ high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            // for left half
            else if(arr[low] <= arr[mid]){  // increasing sequence
                if(arr[low] <= target && target < arr[mid])
                    high = mid-1;
                else 
                    low = mid+1;
            }

            // for right half
            else if(arr[mid] <= arr[high]){
                if(arr[mid] < target && target <= arr[high]) // "=" for failing tc [5,1,3], target=3
                    low = mid+1;
                else 
                    high = mid-1;               
            }
        }

        return false;       
    }
};

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

The only difference where SA-1 is breaking is :
 [1,0,1,1,1], target = 0

 at time when high = low = mid = 1,
    in that case shrink the search space.
*/