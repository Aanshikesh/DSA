class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = -1;
        int b = -1;
        int s =0, e = nums.length-1;
        while(s<=e){
            int mid = s  + (e-s)/2;
            if(nums[mid] == target) {
                a = mid;
                break;
            }
            if(nums[mid]<target) s = mid+1;
            else e = mid-1;
        }
        if(a==-1) return new int[]{-1,-1};
        int c =a;
        for(int i =c;i>=0;i--){
            if(nums[i]==target) a =i;
            else break;
        }
        for(int i=c;i<nums.length;i++){
            if(nums[i]==target) b =i;
            else break;
        }
        return new int[]{a,b};
    }
}