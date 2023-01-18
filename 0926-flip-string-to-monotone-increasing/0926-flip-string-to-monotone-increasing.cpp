class Solution {
public:
    int minFlipsMonoIncr(string s) {

        int len = s.size(), tzero=0, tone=0, mini = 0;

// Count 1's at LHS and 0's at RHS
        for(int i=0; i<len ; i++){
            if(s[i] == '0')
                tzero++ ;     
            else 
                tone++; 
                
            tzero = min(tzero , tone);
        }

        return tzero;
    }
};