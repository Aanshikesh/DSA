
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (x >= 0 && y >= 0 && x < m && y < n
                        && grid[x][y] == 1) {

                        grid[x][y] = 2;
                        fresh--;
                        q.add(new int[]{x, y});
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
