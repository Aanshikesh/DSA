
class Solution {

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 1: Build adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // Step 2: Count connected components
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        return n - components;
    }
}
