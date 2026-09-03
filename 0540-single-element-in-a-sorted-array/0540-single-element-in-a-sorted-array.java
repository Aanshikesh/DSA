class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s =0, e  = nums.length -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid>=1 && mid<(nums.length-1 ) && nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) return nums[mid];
            else if(mid>=1 && nums[mid]==nums[mid-1]){
                if(mid%2==0) e = mid-1;
                else s = mid+1;
            }
            else {
                if(mid%2!=0) e = mid-1;
                else s = mid+1;
            }
        }
        return nums[s-1];
    }
}