import java.util.ArrayList;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});  
                }
            }
        }
        int x = list.size();
        for(int i =0;i<x;i++){
            changezero(matrix,list.get(i)[0],list.get(i)[1] , n,m);
        }

    }
    private void changezero(int[][] matrix, int i ,int j , int n , int m){
        for(int a=0;a<m;a++){
            matrix[i][a]=0;
        }
        for(int a=0;a<n;a++){
            matrix[a][j]=0;
        }
    }
}
