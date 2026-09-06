class Solution {
    public int countRotations(String s, int k) {
        int count =0;
        String str = s+s;
        int n = s.length();
        for(int i=0;i<n;i++){
            int score =0;
            for(int j=i+1;j<n+i;j++){
                if(str.charAt(j)==str.charAt(j-1)) score+=1;
            }
            if(score==k) count+=1;
        }
        return count;
        
    }
}