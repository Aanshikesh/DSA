class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int s = 1;
        int e = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            e = Math.max(e,nums[i]);
        } 
        while(s<=e){
            int mid = s +  (e-s)/2;
            int sum = sum(nums,mid,n);
            if(sum<=threshold) e = mid-1;
            else s = mid+1;

        }   
        return s;
        
    }
    private int sum(int[] nums , int mid , int n){
        int sum =0;
        for(int i =0;i<n;i++){
            sum+= Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
}