class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        String res = "";
        int[] lastIndex = new int[26]; // can also declare int[] arr;
        Arrays.fill(lastIndex, 0);

        boolean[] taken = new boolean[26];
        Arrays.fill(taken, false);

        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<len; i++){
            int value = s.charAt(i) - 'a';
            lastIndex[value] = i;
        }

        for(int i=0; i<len; i++){
            int curr = s.charAt(i) - 'a'; // stores the integer value of char

            if(taken[curr]) // already taken
                continue;

            // arrange stack like maxheap
            // check last index of the top value of stack
            while(!st.isEmpty() && st.peek() > s.charAt(i) && lastIndex[st.peek() - 'a'] > i){
                    taken[st.peek() - 'a'] = false;
                    st.pop();
            }

            st.push(s.charAt(i));
            taken[curr] = true;
        }

        while(!st.empty()){
            res += st.peek();
            st.pop();
        }

        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        sb.reverse();

        return sb.toString();
    }
}