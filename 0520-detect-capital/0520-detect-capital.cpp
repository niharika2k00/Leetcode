class Solution {
public:
    bool detectCapitalUse(string word) {

       int len = word.size(), countUpper = 0;

      if(len == 1)
        return true;

      for (auto it: word){
          if(isupper(it))
              countUpper++;
      }
 
//  all caps, small and first cap.
      if(countUpper == len || countUpper == 0 || countUpper == 1 && isupper(word[0]))
          return true;
      return false;
    }
};