class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
    
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    if ((long)m * k > bloomDay.length) return -1;
    for(int i =0;i<bloomDay.length;i++ ){
        max = Math.max(max,bloomDay[i]);
        min = Math.min(min,bloomDay[i]);

    } 
    

    while(min<=max){
        int mid = min + (max-min)/2;
        if(possible(bloomDay,mid,m,k)) max = mid-1;
        else min = mid+1;
    }
    return min;

    }
    public boolean possible(int[] arr , int mid , int m, int k){
        int cnt=0;
        int noOfB=0;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i]<=mid) cnt++;
            else{ noOfB += cnt/k; cnt=0;}
        }

         noOfB += cnt/k;

         if(noOfB>=m) return true;

         return false;

    }
}