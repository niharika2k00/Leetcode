class Solution {
public:
    char findMinUsingDFS(unordered_map<char, vector<char>> &adj, char currChar, vector<int> &visited){
        visited[currChar - 'a'] = 1; // mark as visited
        char minChar = currChar;

        for(auto &ele: adj[currChar]){
            if(visited[ele - 'a'] == 0)
                minChar = min(minChar , findMinUsingDFS(adj, ele, visited));
        }

        return minChar;
    }

    string smallestEquivalentString(string s1, string s2, string baseStr) {
        unordered_map<char, vector<char>> adj;
        string result;
        int len = s1.size();

        for(int i=0; i<len; i++){
            char u = s1[i];
            char v = s2[i];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        for(int i=0 ; i<baseStr.size() ; i++){
            char ch = baseStr[i];
            vector<int> visited(26,0);

            char val = findMinUsingDFS(adj, ch, visited);
            result += val;
        }

        return result;
    }
};






