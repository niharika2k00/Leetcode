class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {

// trust[i] = [ai, bi] representing that the person labeled ai TRUSTS the person labeled bi.
        vector<int> trustedCount(n+1), trustByCount(n+1);
        int i, len = trust.size();

        if (len == 1)
            return trust[0][1];

        for (i = 0; i < len; i++) {
            trustByCount[trust[i][0]]++; // person who trust others
            trustedCount[trust[i][1]]++; //  person who is being Trusted
        }

        /* 
            Check :  the person who will be the town judge will NOT TRUST OTHERS   trustedByCount[i] == 0 ,
                      but he is trusted by EVERYONE (n - 1) person.
        */
        for (i = 1; i <= n; i++) {
            if (trustedCount[i] == (n - 1) && trustByCount[i] == 0)
                return i;
        }

        return -1;
    }
};
