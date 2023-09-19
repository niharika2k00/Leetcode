class Solution {
public:
    int minDeletions(string s) {
        unordered_map<char, int>mp; // char - count
        priority_queue<int> pq; // stores the freq
        int count=0;

        for(auto it: s)
            mp[it]++;
        
        for(auto it: mp)
            cout << it.first << " - " << it.second << endl;

        for(auto it: mp)
            pq.push(it.second);
        
        // max element at the top
        while(pq.size() != 1){
            int top = pq.top();
            pq.pop();

            if(top == pq.top() && top != 0) // compare with 2nd top element
            {
                pq.push(top - 1);
                count++;
            }
        }

        return count;
    }
};
