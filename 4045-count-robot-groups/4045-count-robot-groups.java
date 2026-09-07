class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        int count =n;
        int maxspeed = speed[n-1];
        for(int i=n-1;i>0;i--){
            if(position[i]-position[i-1]<=distance){ 
                count--;
            }
            else if(speed[i-1]>maxspeed){
                count--;
            }
            else maxspeed = speed[i-1];
        }

        return count;
    }
}