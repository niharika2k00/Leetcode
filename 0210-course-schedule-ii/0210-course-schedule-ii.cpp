class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
    
    // BFS Method - Topological sort
        unordered_map<int, vector<int>> adj;
        vector<int>indegree(numCourses, 0);
        vector<int>res;

        for(auto &it: prerequisites){
            int u = it[1];
            int v = it[0];
            adj[u].push_back(v);
        }

        for(int i=0; i<numCourses; i++){
            for(auto &it: adj[i]){
                indegree[it]++;
            }
        }

        queue<int> que;
        int count = 0;

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
                que.push(i);
        }

        while(!que.empty()){
            int ele = que.front();
            que.pop();
            res.push_back(ele);
            count++;

            for(auto &it: adj[ele]){
                indegree[it]--;

                if(indegree[it] == 0)
                    que.push(it);
            }
        }

        if(numCourses != count)
            return {};

        return res;  
    }
};