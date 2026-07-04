class Solution {

    public void dfs(HashMap<Integer, List<int[]>> adj, int u, boolean[] visited, int[] result) {

        visited[u] = true;

        for (int[] vec : adj.getOrDefault(u, new ArrayList<>())) {
            int v = vec[0];
            int c = vec[1];

            result[0] = Math.min(result[0], c);

            if (!visited[v]) {
                dfs(adj, v, visited, result);
            }
        }
    }

    public int minScore(int n, int[][] roads) {

        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] vec : roads) {
            int u = vec[0];
            int v = vec[1];
            int c = vec[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, c});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, c});
        }

        boolean[] visited = new boolean[n + 1];
        int[] result = {Integer.MAX_VALUE};

        dfs(adj, 1, visited, result);

        return result[0];
    }
}