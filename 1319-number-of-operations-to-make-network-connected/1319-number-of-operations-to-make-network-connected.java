
class Solution {
    public int makeConnected(int V, int[][] edges) {
        if (edges.length < V - 1) return -1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }

        return count - 1;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] vis) {

        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, adj, vis);
            }
        }
    }
}
