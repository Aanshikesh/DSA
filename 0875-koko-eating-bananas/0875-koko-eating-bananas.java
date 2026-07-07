class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ans = Integer.MAX_VALUE;
        int totalHours = 0;
        int s = 1, e = piles[piles.length-1];
        while(s<=e){
            int mid = s + (e-s)/2;
            totalHours = total(piles,mid);
            if(totalHours<=h){
                ans = mid;
                e= mid-1;
            }
            else s = mid+1;
        }
        return ans;
        
    }
    public static int total(int[]piles , int mid){
        int hours = 0 ;
        for(int i =0;i<piles.length;i++){
            hours += Math.ceil((double) piles[i] / mid);

        }
        return hours;


    }
}