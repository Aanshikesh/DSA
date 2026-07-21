class Solution {
    int count = 0;

    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        int maxInSubtree = Math.max(node.val, Math.max(leftMax, rightMax));

        if (node.val >= leftMax && node.val >= rightMax) {
            count++;
        }

        return maxInSubtree;
    }
}