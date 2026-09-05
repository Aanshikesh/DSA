class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans=recur(word1 , word2 , 0,0,dp);
        return ans;
    }
    int recur(String s1, String s2 ,int i,int j,int[][] dp ){
        if(i >=s1.length()){
            return s2.length()-j; 
        }

        if(j >=s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]= recur(s1,s2,i+1,j+1,dp);
        int insert = 1+ recur(s1,s2,i,j+1,dp);
        int delete = 1+recur(s1,s2,i+1,j,dp);
        int replace  =  1+ recur(s1,s2,i+1,j+1,dp);
        return dp[i][j]=Math.min(insert, Math.min(delete,replace));
    }
}