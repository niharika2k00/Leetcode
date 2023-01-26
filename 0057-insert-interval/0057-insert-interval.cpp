class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        int nwStart=newInterval[0], nwEnd=newInterval[1], len=intervals.size(), i=0;

// if start is MORE than end of interval, then add all
        while(i < len && nwStart > intervals[i][1]){
            res.push_back(intervals[i]);
            i++;
        }

// lies in the range   nwStart >= intervals[i][0] && nwStart <= intervals[i][1]
        while(i < len && nwEnd >= intervals[i][0]){
                nwStart = min(nwStart, intervals[i][0]);
                nwEnd = max(nwEnd, intervals[i][1]);
                i++;
        }

        res.push_back({nwStart, nwEnd});

        // if remaining
        while(i < len)
            res.push_back(intervals[i++]);
        
        return res;
    }
};
