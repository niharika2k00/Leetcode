class Solution {
public:
    typedef pair<int,int> P;

    int primsAlgo(vector<vector<P>>adjList, int root, int len){
        priority_queue<P, vector<P>, greater<P>> pq; // taking a min heap. (cost, destination)
        vector<bool> inMST(len, false);
        int sum=0;
         
        pq.push({root, 0});

        while(!pq.empty()){
            auto top = pq.top();
            pq.pop();
            int cost = top.first;
            int node = top.second;

            if(inMST[node] == true)
                continue;
            
            inMST[node] = true; // marked current node visited
            sum += cost;
            
            // traverse the adjacency list
            for(auto neighbour: adjList[node]){
                int dest = neighbour.first;
                int cost = neighbour.second;

                if(!inMST[dest])
                    pq.push({cost, dest});
            }
        }
        
        return sum;
    }

    int minCostConnectPoints(vector<vector<int>>& points) {
        int len = points.size();
        vector<vector<P>> adjList(len); // (dest, cost)

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                int cost = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                adjList[i].push_back({j, cost});
                adjList[j].push_back({i, cost});
            }
        }

        int sum = primsAlgo(adjList, 0, len);
        return sum;
    }
};