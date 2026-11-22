
class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (time > dist[row][col]) continue;

            if (row == n - 1 && col == n - 1) {
                return time;
            }

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {

                    int newTime = Math.max(time, grid[nr][nc]);

                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.offer(new int[]{newTime, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}
