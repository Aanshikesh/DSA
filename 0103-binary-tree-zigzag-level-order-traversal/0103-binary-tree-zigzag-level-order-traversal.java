
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (leftToRight) {
                    levelList.add(current.val);
                } else {
                    levelList.add(0, current.val);  
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight; 
        }

        return result;
    }
}