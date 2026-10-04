class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Set<Integer> set = new HashSet<>();

        // Find all children
        for (int i = 0; i < n; i++) {

            if (leftChild[i] != -1) {
                if (set.contains(leftChild[i])) return false;
                set.add(leftChild[i]);
            }

            if (rightChild[i] != -1) {
                if (set.contains(rightChild[i])) return false;
                set.add(rightChild[i]);
            }
        }

        // Exactly one node should not be a child = root
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                if (root != -1) return false;
                root = i;
            }
        }

        if (root == -1) return false;

        // Check that all nodes are connected
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        visited.add(root);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (leftChild[node] != -1) {
                if (!visited.add(leftChild[node])) return false;
                q.offer(leftChild[node]);
            }

            if (rightChild[node] != -1) {
                if (!visited.add(rightChild[node])) return false;
                q.offer(rightChild[node]);
            }
        }

        return visited.size() == n;
    }
}