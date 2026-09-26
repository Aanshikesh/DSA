class Solution {
    public int minFlips(String target) {
        int count =0;
        char c= '0';
        for(char ch : target.toCharArray()){
            if(ch==c) continue;
            else{
                count++;
                if(c=='0') c='1';
                else c='0';
            }
        }
        return count;
    }
}