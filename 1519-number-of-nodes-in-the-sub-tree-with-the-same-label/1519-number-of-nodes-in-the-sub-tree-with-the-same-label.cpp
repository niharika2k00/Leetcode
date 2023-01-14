class Solution {
public:
// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

    vector<int> DFS(unordered_map<int, vector<int>>&adj, int curr, int parent, vector<int>&result, string &labels){
        vector<int> myCount(26,0);

        char currLabel = labels[curr];
        myCount[currLabel - 'a'] = 1;

        for(auto &conn: adj[curr]){
            if (conn == parent)
                continue;

            vector<int>childCount(26,0);
            childCount = DFS(adj, conn, curr, result, labels);    

            for(int i=0 ; i<26 ; i++)
                myCount[i] += childCount[i];
        }

        result[curr] = myCount[currLabel - 'a'];  // count of the label
        return myCount;
    }

    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        unordered_map<int, vector<int>> adj;

        for(auto &vec: edges){
            int u = vec[0];
            int v = vec[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        vector<int>result(n,0); 
        DFS(adj, 0, -1, result, labels);

        return result;
    }
};