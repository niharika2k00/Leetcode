class Solution {
public:
// Reference : https://www.youtube.com/watch?v=qSBvKlUq0xo

    int DFS(unordered_map<int, vector<int>>&adj, int curr, int parent, vector<bool>& hasApple){
        int time=0;

        for(int &conn : adj[curr]){
            if(conn == parent)
                continue;

            int timeTakenByChild = DFS(adj, conn, curr, hasApple);

            if(timeTakenByChild > 0 || hasApple[conn])
                time += timeTakenByChild + 2;
        }

        return time;
    }

    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {

        // create the adjacency list for storing the edges
        unordered_map<int, vector<int>>adj;
        int len = edges.size();

        for(int i=0 ; i<len ; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        return DFS(adj, 0, -1, hasApple);
        
    }
};