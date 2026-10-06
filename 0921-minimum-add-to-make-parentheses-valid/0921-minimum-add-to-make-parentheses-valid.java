class Solution {
    public int minAddToMakeValid(String s) {
        int count =0;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray() ){
            if(ch =='(') st.push('(');
            else{
                if(!st.isEmpty() && st.peek()=='(') st.pop();
                else {
                    count++;
                }
            }
        }
        return st.size() +count;
    }
}