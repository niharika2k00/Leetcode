//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    
    bool DFS(vector<int> adj[], vector<bool>&visited, int u, int parent){
        
        visited[u] = true;
        
        // for(auto it = adj[u].begin(); it != adj[u].end(); it++) {...}
        for(auto &v: adj[u]){
            if(v == parent)
                continue;
                
            if(visited[v])
                return true;
                
            if(DFS(adj, visited, v, u))
                return true;
        }
        
        return false;
    }
    
    
    bool isCycle(int v, vector<int> adj[]) {
        
        vector<bool> visited(v,false);
        
        // for(int i=0 ; i<v ; i++){
            if( !visited[i] && DFS(adj, visited, i, -1) ) // vertex not visited and encountered a cycle
                return true;
        }

        return false;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}
// } Driver Code Ends