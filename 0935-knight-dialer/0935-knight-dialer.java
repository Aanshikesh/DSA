class Solution {
    int mod = (int) 1e9 + 7;
    int[][] dp = new int[10][5001];

    public int knightDialer(int n) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
            Arrays.fill(dp[i], -1);
        }

        list.get(0).add(4);
        list.get(0).add(6);

        list.get(1).add(6);
        list.get(1).add(8);

        list.get(2).add(7);
        list.get(2).add(9);

        list.get(3).add(4);
        list.get(3).add(8);

        list.get(4).add(9);
        list.get(4).add(3);
        list.get(4).add(0);

        list.get(6).add(0);
        list.get(6).add(1);
        list.get(6).add(7);

        list.get(7).add(2);
        list.get(7).add(6);

        list.get(8).add(1);
        list.get(8).add(3);

        list.get(9).add(2);
        list.get(9).add(4);

        long ans = 0;

        for (int i = 0; i < 10; i++) {
            ans = (ans + dfs(i, n - 1, list)) % mod;
        }

        return (int) ans;
    }

    public int dfs(int i, int n, List<List<Integer>> list) {

        if (n == 0) {
            return 1;
        }

        if (dp[i][n] != -1) {
            return dp[i][n];
        }

        long count = 0;

        for (int val : list.get(i)) {
            count = (count + dfs(val, n - 1, list)) % mod;
        }

        return dp[i][n] = (int) count;
    }
}