class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int i =0;i<=grid.length;i++){
            Arrays.fill(dp[i],0);
        }
        return recur(grid , grid.length-1 , grid[0].length-1,dp);
    }
    int recur(int[][] grid , int m ,int n,int[][] dp){
        if(n==0 && m==0) return grid[0][0];
        if(dp[m][n]!=0) return dp[m][n];
        int up=(int)1e9;
        int left =(int)1e9;
        if(n>0) left = grid[m][n] + recur(grid, m , n-1,dp);
        if(m>0) up = grid[m][n] + recur(grid , m-1,n,dp);
        return dp[m][n]=Math.min(up,left);

    }
}