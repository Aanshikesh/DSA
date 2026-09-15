class Solution {
    int[][] dp;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k==1) return n;
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(s, k, 0, k - 1);
    }

    int recur(String s, int k, int i, int j) {
        if (i >= s.length() || j >= s.length())
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take = 0;
        int grow = 0;
        int slide = 0;
        if (isPalindrome(s, i, j)) {
            take = 1 + recur(s, k, j + 1, j + k);
            grow = recur(s, k, i, j + 1);
            slide = recur(s, k, i + 1, j + 1);
            return dp[i][j] =  Math.max(take, Math.max(grow, slide));
        }
        grow = recur(s, k, i, j + 1);
        slide = recur(s, k, i + 1, j + 1);
        return dp[i][j]= Math.max(grow, slide);
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}