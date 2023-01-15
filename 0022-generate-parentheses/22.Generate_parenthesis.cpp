class Solution {
public:

    void DP(int open, int close, vector<string> &res, string pattern){  
        // Base case
        if( open == 0 && close == 0){
            res.push_back(pattern);
            return;
        }

        // only close remain
        if(open == 0 && close){
            for(int i=0 ; i<close ;i++){
                pattern += ')';
            }
            res.push_back(pattern);
            return;
        }
        

        if( open > 0 ){
            DP(open-1, close, res, pattern+"(" );
        }
           
        if( open < close){  // as without open braces we can't close            
            pattern += ')';
            DP(open, close-1, res, pattern);
        }  

        return;
    }

    vector<string> generateParenthesis(int n) {    // DRAW THE RECURSIVE TREE
        int open, close;
        open = close = n;
        vector<string>res;

        DP(open, close, res, "");

        return res;
    }
};
