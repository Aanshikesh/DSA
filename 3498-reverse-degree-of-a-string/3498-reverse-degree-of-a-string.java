class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        int i=1;
        for(char ch: s.toCharArray()){
            int a = 26- (ch-'a');
            ans+= i*a;
            i++;
        }
        return ans;
    }
}