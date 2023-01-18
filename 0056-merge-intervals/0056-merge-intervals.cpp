class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        sort(intervals.begin(), intervals.end());
        int start=intervals[0][0], end = intervals[0][1], len=intervals.size();

        for(int i=1; i<len ; i++){
            if(end >= intervals[i][0])
            {
                end = max(intervals[i][1],end);  // taking max bcz [[1,4],[2,3]] res: [1,4]
            }
            else{
                res.push_back({start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }


        }

        res.push_back({start,end});

        return res;
    }
};