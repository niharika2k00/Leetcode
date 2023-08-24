class Solution {
public:
    typedef pair<int, char> P;

/*  Intuition:
-----------------
Store freq in a HashMap
Store the same in Priority Queue
Pick 1 and append in a string then continues...
*/

    string reorganizeString(string s) {
        string res = "";
        int len = s.size();
        unordered_map<char, int>mp;
        priority_queue<P, vector<P>> heap; // taking maxHeap as default

        for(auto it: s){
            mp[it]++;
            if(mp[it] > (len+1)/2) // not possible if freq more for a single char {a 3}
                return "";
        }

        for(auto it=mp.begin(); it!=mp.end(); it++){
            heap.push({it->second, it->first}); // (freq, char) {3 a}
        }

        while(heap.size() >= 2){
            P p1 = heap.top();
            heap.pop();
            P p2 = heap.top();
            heap.pop();

            res = res + p1.second + p2.second;

            // decrement their frequency and push
            if(--p1.first > 0)
                heap.push(p1);
            if(--p2.first > 0)
                heap.push(p2);
        }
        
        // If there's only one character left in the priority queue, add it to the result
        if(!heap.empty()){
            res += heap.top().second;
        }

        return res;
    }
};