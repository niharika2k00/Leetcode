class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> res;
        int len = arr.size();

        // Min-Heap Priority Queue
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        for(int i=0 ; i<len; i++){
            pq.push({abs(x-arr[i]), arr[i]});
        }

        while(k--){
            res.push_back(pq.top().second);
            pq.pop();
        }

        sort(res.begin(), res.end());
        return res;
    }
};