class Solution {
public:
    bool isCollide(int a, int b){
        if((a<0 && b>0) || (a>0 && b<0)) // opposite sign means collide
            return true;
        return false;   
    }

    vector<int> asteroidCollision(vector<int>& asteroids) {
      stack<int> st;
      int len=asteroids.size();

      if(len < 2)
        return asteroids;

      for (int i=0; i<len; i++){
        int curr = asteroids[i];

        // right-moving(+) asteroids will never collide with any previously encountered asteroids. So push all +ve
        if(st.empty() || curr > 0)
            st.push(curr);
        else {
            while(!st.empty() && st.top() > 0 && abs(st.top()) < abs(curr)) // if -ve magnitude more
                st.pop();

            if(!st.empty() && (st.top()) == abs(curr)) // opposite direction with same magnitude
                st.pop();
            else if(st.empty() || st.top() < 0){ // if no collision then put the neg val otherwise we will lose data TC [-2,-1,1,2]
                st.push(curr);
            }    
        }
    }

        int size = st.size();
        vector<int> res(size,0);
        
        // store in reverse order
        while(!st.empty()){
            res[--size] = st.top();
            st.pop();
        }

        return res;
      }
};