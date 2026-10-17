class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] inorder = new int[n];
        for (int i =0;i<edges.size();i++) {
            inorder[edges.get(i).get(1)]++;
        }
        for(int i =0;i<n;i++){
            if(inorder[i]==0) ans.add(i);
        }
        return ans;
    }
}