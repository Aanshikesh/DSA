class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int tsum=0;
        int n=arr.length;
        for(int num:arr){
            tsum+=num;
        }
        if(tsum%3!=0){
            return false;
        }
        
        int targetsum=tsum/3;
        int count=0;
        int sum=0;
        for(int num:arr){
            sum+=num;
            if(sum==targetsum){
                count++;
                sum=0;
            }
        }
        return count>=3?true:false;
    }
}