class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;
        int n = drones.length;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
                int d = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
                if(d<min && d<=drones[i][2]){
                    min = d;
                    idx=i;
                }
        }
        return idx;
    }
}