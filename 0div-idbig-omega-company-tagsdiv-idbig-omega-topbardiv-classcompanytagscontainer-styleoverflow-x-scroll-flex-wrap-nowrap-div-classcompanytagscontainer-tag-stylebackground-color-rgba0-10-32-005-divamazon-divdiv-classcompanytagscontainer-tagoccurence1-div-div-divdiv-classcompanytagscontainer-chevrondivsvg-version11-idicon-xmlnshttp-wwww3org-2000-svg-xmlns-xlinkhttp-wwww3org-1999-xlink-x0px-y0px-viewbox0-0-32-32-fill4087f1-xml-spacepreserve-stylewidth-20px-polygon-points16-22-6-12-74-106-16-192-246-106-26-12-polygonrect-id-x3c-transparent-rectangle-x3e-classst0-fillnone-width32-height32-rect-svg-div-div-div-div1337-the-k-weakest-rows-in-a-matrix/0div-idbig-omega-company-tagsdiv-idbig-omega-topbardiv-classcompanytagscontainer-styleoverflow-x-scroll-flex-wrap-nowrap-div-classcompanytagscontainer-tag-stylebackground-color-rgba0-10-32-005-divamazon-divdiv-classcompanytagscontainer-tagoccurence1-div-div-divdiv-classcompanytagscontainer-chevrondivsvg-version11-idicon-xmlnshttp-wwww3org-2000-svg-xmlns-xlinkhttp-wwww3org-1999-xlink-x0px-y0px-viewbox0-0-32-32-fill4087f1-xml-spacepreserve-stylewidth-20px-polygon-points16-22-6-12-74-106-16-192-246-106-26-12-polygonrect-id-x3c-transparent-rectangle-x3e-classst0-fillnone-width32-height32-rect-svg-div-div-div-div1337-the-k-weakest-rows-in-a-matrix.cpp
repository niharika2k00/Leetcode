class Solution {
public:
    typedef pair<int, int> pint;

    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        int row=mat.size(), col=mat[0].size();
        vector<int>res;
        priority_queue<pint, vector<pint>, greater<pint>> pq; // minHeap so that min at the top

        for(int i=0; i<row; i++){
            int soldiers=0;
            for(int j=0; j<col; j++){
                if(mat[i][j] == 1)
                    soldiers++;
            }
            pq.push({soldiers, i});
            // if(pq.size() > k)  -- if maxHeap used
                // pq.pop();
        }

        while(k--){
            int ele = pq.top().second; // index
            res.push_back(ele);
            pq.pop();
        }

        return res;
    }
};