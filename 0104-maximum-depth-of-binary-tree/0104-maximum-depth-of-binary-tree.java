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
 class pair{
    TreeNode node;
    int depth;
    pair(TreeNode node , int depth){
        this.node  = node;
        this.depth = depth;
    }
 }
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int max = 0;
        Queue<pair> queue  =  new LinkedList<>();
        queue.offer(new pair(root,1));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                pair p = queue.poll();
                TreeNode node = p.node;
                int depth = p.depth;
                max = Math.max(max,depth);
                if(node.left!=null) queue.offer(new pair(node.left,depth+1));
                if(node.right!=null) queue.offer(new pair(node.right,depth+1));
                size--;
            }
        } 
        return max;
    }
}