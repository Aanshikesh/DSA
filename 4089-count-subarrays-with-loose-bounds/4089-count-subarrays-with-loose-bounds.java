class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans =0;
        int l =0, r =0;
        while(r<n){
            if(nums[r]<=maxK && nums[r]>=minK) {
                r++;
                ans+= r-l;
            }
            else {
                r++;
                l=r;
            }


        }
        return ans;
    }
}