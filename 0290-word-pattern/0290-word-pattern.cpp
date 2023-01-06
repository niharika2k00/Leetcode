class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        string a = "",b = "";
        int ctr = 1;
        unordered_map<char, int> mp1;
        unordered_map<string, int> mp2;

        // length check


        // actual logic
        for (auto it: pattern)
        {
            if(mp1.find(it) != mp1.end()) // found
            {
                int val = mp1[it];
                a += to_string(val);
            }
            else{
                mp1[it]= ctr;
                a += to_string(ctr); ctr++;
            }
        }

        cout << a << endl;

        ctr = 1;
        string word = "";

        for (int i = 0 ; i < s.size() ; i++)
        {
            if(s[i] == ' ')
            {
                if(mp2.find(word) != mp2.end() ) // found
                {
                   int val = mp2[word];
                   b += to_string(val); 
                   word = "";
                }
                else{
                    mp2[word] = ctr;
                    b += to_string(ctr); ctr++;
                    word = "";
                }

            }
            else{
                word += s[i];
            }
        }

        // cout << "word => " << word << endl;

        //  for the last word
        if (mp2.find(word) == mp2.end())  // not found
            b += to_string(ctr);
 
        else  {
            int val = mp2[word];
            b += to_string(val); 
        }
             

 cout << "a = " << a << " b = " << b << endl;
        if ( a.compare(b) == 0)
            return true;
        return false;    
    }
};







