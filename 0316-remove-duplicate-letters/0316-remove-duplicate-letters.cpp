class Solution {
public:
    string removeDuplicateLetters(string s) {
    // output must be a subsequence
        int len = s.size();
        string res = "";
        // lastIndex for storing the lastIndex of the char
        vector<int> lastIndex(26, 0);
        vector<bool> taken(26, false);
        stack<char> st;

        for(int i=0; i<len; i++){
            int value = s[i] - 'a';
            lastIndex[value] = i;
        }

        for(int i=0; i<len; i++){
            int curr = s[i] - 'a'; // stores the integer value of char

            if(taken[curr]) // already taken
                continue;

            // check last index of the top value of stack
            while(!st.empty() && st.top() > s[i] && lastIndex[st.top() - 'a'] > i){
                // if(st.top() > s[i] && lastIndex[st.top() - 'a'] > i){ // c > b
                    taken[st.top() - 'a'] = false;
                    st.pop();
                // }
            }

            st.push(s[i]);
            taken[curr] = true;
        }

        while(!st.empty()){
            res += st.top();
            st.pop();
        }

        cout << res;
        reverse(res.begin(), res.end());
        return res;
    }
};