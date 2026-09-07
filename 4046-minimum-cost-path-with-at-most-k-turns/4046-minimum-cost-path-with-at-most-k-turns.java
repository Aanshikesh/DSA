class Solution {
    class Pair {
        int i;
        int j;
        int cost;
        int k;
        int direction;

        Pair(int i, int j, int cost, int k, int direction) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cost = cost;
            this.direction = direction;
        }
    }

    //up - 0
    //down - 1
    //left - 2
    //right - 3
    //start - 4
    public int minCost(int[][] grid, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });
        int n = grid.length;
        int m = grid[0].length;

        pq.offer(new Pair(0, 0, grid[0][0], k, 4));
        int[][] dirs = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        int[][][][] dp = new int[n + 1][m + 1][k + 1][5];

        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, Integer.MAX_VALUE);
                }
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.k < 0)
                continue;
            if (p.i == n - 1 && p.j == m - 1) {
                return p.cost;
            }

            for (int l = 0; l < dirs.length; l++) {
                int ni = p.i + dirs[l][0];
                int nj = p.j + dirs[l][1];

                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    if (p.direction == 4 && dp[ni][nj][p.k][l] > p.cost + grid[ni][nj]) {
                        //4 direction me
                        dp[ni][nj][p.k][l] = p.cost + grid[ni][nj];
                        pq.offer(new Pair(ni, nj, p.cost + grid[ni][nj], p.k, l));
                    } else if(p.k > 0 || p.direction == l) {
                        int nk = (l == p.direction) ? p.k : p.k - 1;
                        if(dp[ni][nj][nk][l] <= p.cost + grid[ni][nj]) continue;
                        dp[ni][nj][nk][l] = p.cost + grid[ni][nj];
                        pq.offer(new Pair(ni, nj, p.cost + grid[ni][nj], nk, l));
                    }
                }
            }
        }
        return -1;
    }
}