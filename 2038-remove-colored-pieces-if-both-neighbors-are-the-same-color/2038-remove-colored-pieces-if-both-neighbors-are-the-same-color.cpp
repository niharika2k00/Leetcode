class Solution {
public:
    bool winnerOfGame(string colors) {
        int len = colors.size(), alice = 0, bob = 0;
        bool res;

        for (int i=1; i<len-1; i++ ){
            char prev = colors[i-1];
            char curr = colors[i];
            char next = colors[i+1];

            if(prev == 'A' && prev == curr && curr == next)
                alice++;

            else if(prev == 'B' && prev == curr && curr == next)
                bob++;
        }

        return alice > bob;
    }
};