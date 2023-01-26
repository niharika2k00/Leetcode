class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        unordered_map<int, vector<pair<int,int>>> adj;  // pair bcz have to store 2 ele

        for(auto &it: flights){
            adj[it[0]].push_back({it[1], it[2]});
        }

        priority_queue< vector<int>, vector<vector<int>>, greater<vector<int>> > minHeap;  // {dist, src, stop}
        vector<int> distance(n + 1, INT_MAX);  // infinite store distance
        minHeap.push({0, src, 0});

        while(!minHeap.empty()){
            auto ele = minHeap.top();
            minHeap.pop();

            int cost = ele[0];
            int currVertex = ele[1]; // source
            int stop = ele[2];

            if(currVertex == dst) 
                return cost;

            //Optimization to avoid TLE
            if(distance[currVertex]<stop)
                continue;
            else    
                 distance[currVertex]=stop;

            if(stop > k ) continue;
            
            for( auto &it : adj[currVertex] )
                minHeap.push( { cost+it.second, it.first, stop+1 } );  // dest+cost , source , stop
        }

        return -1; // not possible

    }
};
