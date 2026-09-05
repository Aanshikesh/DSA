class Pair {
    int row;
    int col;
    TreeNode node;

    Pair(int row, int col, TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> list of (row, value)
        TreeMap<Integer, List<int[]>> mp = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, root));

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            int row = p.row;
            int col = p.col;
            TreeNode node = p.node;

            mp.computeIfAbsent(col, k -> new ArrayList<>())
              .add(new int[]{row, node.val});

            if (node.left != null) {
                queue.add(new Pair(row + 1, col - 1, node.left));
            }

            if (node.right != null) {
                queue.add(new Pair(row + 1, col + 1, node.right));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : mp.values()) {

            // Sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] arr : list) {
                temp.add(arr[1]);
            }

            ans.add(temp);
        }

        return ans;
    }
}