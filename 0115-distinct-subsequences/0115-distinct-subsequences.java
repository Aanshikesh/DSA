class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int i =0;i<s.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(s, t, 0, 0);
    }

    int recur(String s, String t, int i, int j) {
        if (j == t.length())
            return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pick = 0;
        if (s.charAt(i) == t.charAt(j)) {
            pick = recur(s, t, i + 1, j + 1);
        }
        int nopick = recur(s, t, i + 1, j);

        return dp[i][j]=pick + nopick;
    }
}