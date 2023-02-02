//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:

    bool bipartiteBFS(int curr, vector<int>adj[], vector<int>&color, int currColor){
        
        queue<int> que;
        
        if(color[curr] == -1)
            color[curr] = currColor;
            
        que.push(curr);
        
        while(!que.empty()){
            int u = que.front();
            que.pop();
            
            for(auto &it: adj[u]){
                if(color[it] == color[u])
                    return false;
                
                if(color[it] == -1){
                    color[it] = !color[u];
                    
                    que.push(it);
                }
            }
        }
        
        return true;
    }


    // Main Func
	bool isBipartite(int V, vector<int>adj[]){
	    
	    vector<int> color(V, -1);
	    
        for(int i=0; i<V; i++){
            if(color[i] == -1)
            if(bipartiteBFS(i, adj, color, 1) == false)
	            return false;
        }

	    return true;
	}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}
// } Driver Code Ends