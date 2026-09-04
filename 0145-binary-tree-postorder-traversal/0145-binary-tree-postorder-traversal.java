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
     List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
         Traversal(root);   
        return ans;
    }
    void Traversal(TreeNode root){
        if(root==null) return;
        Traversal(root.left);
        
        Traversal(root.right);
        ans.add(root.val);
    }
}