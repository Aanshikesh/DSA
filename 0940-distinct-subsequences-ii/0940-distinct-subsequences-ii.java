class Solution {
    int MOD = 1000000007;
    Integer[] dp;

    public int distinctSubseqII(String s) {
        dp = new Integer[s.length()];
        return recur(s, s.length() - 1);
    }

    int recur(String s, int i) {
        if (i < 0) return 0;

        if (dp[i] != null) return dp[i];

        char ch = s.charAt(i);
        int last = -1;

        // Find previous occurrence
        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) == ch) {
                last = j;
                break;
            }
        }

        long prev = recur(s, i - 1);

        long ans;

        if (last == -1) {
            ans = (2 * prev + 1) % MOD;
        } else {
            ans = (2 * prev - recur(s, last - 1)) % MOD;
            if (ans < 0) ans += MOD;
        }

        return dp[i] = (int) ans;
    }
}