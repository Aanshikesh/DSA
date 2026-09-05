/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int height = findheight(root);
        return (height!=-1);
    }
    int findheight(TreeNode node) {
        if (node == null)
            return 0;

        int left = findheight(node.left);
        int right = findheight(node.right);
        if(left==-1 || right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;

        return 1 + Math.max(left, right);
    }
}