
class DSU {
    int[] parent, size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    void dfs(int r, int c, int[][] grid,
             boolean[][] visited, DSU ds) {

        int m = grid.length;
        int n = grid[0].length;

        visited[r][c] = true;

        int index = r * n + c;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                grid[nr][nc] == 1) {

                int newIndex = nr * n + nc;

                ds.union(index, newIndex);

                if (!visited[nr][nc]) {
                    dfs(nr, nc, grid, visited, ds);
                }
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        DSU ds = new DSU(m * n);
        boolean[][] visited = new boolean[m][n];

        // Step 1: Group all islands using DFS + DSU
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited, ds);
                }
            }
        }

        int ans = 0;

        // Step 2: Try converting every 0 to 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int total = 1;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] == 1) {

                            int index = nr * n + nc;
                            int parent = ds.find(index);

                            if (set.add(parent)) {
                                total += ds.size[parent];
                            }
                        }
                    }

                    ans = Math.max(ans, total);
                }
            }
        }

        // Step 3: Handle already existing islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    int parent = ds.find(index);
                    ans = Math.max(ans, ds.size[parent]);
                }
            }
        }

        return ans;
    }
}
