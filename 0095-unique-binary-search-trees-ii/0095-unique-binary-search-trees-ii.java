
class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return solve(1 ,n);
    }
    List<TreeNode> solve(int i , int j){
        if(i>j) return null;
        List<TreeNode>list = new ArrayList<>();
        if(i == j) {
            TreeNode node = new TreeNode(i);
            list.add(node);
            return list;
        }
        for(int k=i;k<=j;k++){
            
            List<TreeNode> left = solve(i,k-1);
            List<TreeNode> right = solve(k+1 ,j);
            if(left == null){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(k);
                    node.right = r;
                    list.add(node);
                }
                continue;
            }
            if(right == null){
                for(TreeNode r : left){
                    TreeNode node = new TreeNode(k);
                    node.left = r;
                    list.add(node);
                }
                continue;
            }

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(k);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }
}