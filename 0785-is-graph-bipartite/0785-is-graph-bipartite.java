class Solution {
    public boolean isBipartite(int[][] graph) {
        int color =2;
        int[] vis = new int[graph.length];
        for(int i =0;i<graph.length;i++){
            if(vis[i]==0) {
                if(!solve(graph,vis, i,color)) return false;;
            }
        }
       
    return true;
    }
    Boolean solve(int[][] graph ,int[] vis ,int i , int color){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,color});
        while(!q.isEmpty()){
            int[] x = q.poll();
            vis[x[0]] = x[1];
            // System.out.println(x[0]);
            for(int j : graph[x[0]]){
                if(vis[j]==x[1]) return false;
                else if(vis[j] == 0) q.offer(new int[] {j,-1*x[1]});
            }
         }
         return true;
    }
}