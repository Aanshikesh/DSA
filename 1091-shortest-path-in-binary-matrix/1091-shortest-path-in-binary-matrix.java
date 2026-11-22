class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length;
    int n =  grid[0].length;
      if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
    int[][] dir = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, -1}, {-1, 1}, {-1, -1}, {1, 1}
        };
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    int ans =0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i =0;i<size;i++){
            int[] curr = q.poll();
            if(curr[0]==m-1 && curr[1] ==n-1){
                return ans+1;
            }
        for(int k =0;k<8;k++){
            int nextX = dir[k][0] + curr[0];
            int nextY = dir[k][1] + curr[1];

            if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0 ){
                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY]=true;
            }
        }
        }
        ans++;
    }
    return -1;
    }
}