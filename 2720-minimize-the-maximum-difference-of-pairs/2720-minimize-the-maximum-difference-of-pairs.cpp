class Solution {
public:
    int len;

    int pairGenerate(vector<int>&arr, int mid, int p){
        int countPairs=0, i=0;

        while(i < len-1){
            if((arr[i+1] - arr[i]) <= mid){
                countPairs++;
                i += 2;
            }
            else 
                i++;
        }

        return countPairs >= p;
    }

    int minimizeMax(vector<int>& arr, int p) {
        len=arr.size();
        sort(arr.begin(), arr.end());
        int low=0, mid, res=0, high= arr[len-1] - arr[0];
        // binary search performed between 0 - max_possible_diff(here last - first ele will be max diff)

        while(low <= high){
            mid = low + (high - low)/2;

            if(pairGenerate(arr, mid, p)){
                high = mid - 1;
                res = mid;
            }
            else 
                low = mid+1;
        }

        return res;
    }
};
