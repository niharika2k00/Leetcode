class Solution {
public:
    void DFS(unordered_map<int, vector<int>> &adj, vector<bool>&visited, int u){

        visited[u] = true;
        
        for(auto &v: adj[u]){
            if(!visited[v]){
                DFS(adj, visited, v);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        
        unordered_map<int, vector<int>> adj;
        int totalVertex = isConnected.size(), count=0;
        vector<bool> visited(totalVertex,false);

    // Create the adjacency list
        for(int i = 0; i<totalVertex; i++) {
            for(int j = 0; j<totalVertex; j++) {
                if(isConnected[i][j] == 1) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }

        for(int i=0; i<totalVertex; i++){
            if(!visited[i]){
                count++;
                DFS(adj, visited, i);
            }
        }

        return count;
    }
};
