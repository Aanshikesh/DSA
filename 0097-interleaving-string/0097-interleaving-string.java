class Solution {

    int[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return recur(s1, s2, s3, 0, 0, 0);
    }

    boolean recur(String s1, String s2, String s3, int i, int j, int k) {

        if (k >= s3.length())
            return true;

        // already calculated
        if (dp[i][j][k] != -1)
            return dp[i][j][k] == 1;

        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {

            if (recur(s1, s2, s3, i + 1, j, k + 1))
                ans = true;
        }

        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {

            if (recur(s1, s2, s3, i, j + 1, k + 1))
                ans = true;
        }

        dp[i][j][k] = ans ? 1 : 0;

        return ans;
    }
}