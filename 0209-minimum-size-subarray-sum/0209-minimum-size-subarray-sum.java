class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l =0,r=0;
        int sum =0;
        int ans = (int)1e9;
        while(l<=r && r<nums.length){
            if(sum<target){
                sum+= nums[r];
                 r++;

            }
            else{
               while(sum>=target) {
                ans = Math.min(ans , r-l);
                sum-=nums[l];
                l++;}
            }

        }
        while (sum >= target) {
            ans = Math.min(ans, r - l);
            sum -= nums[l];
            l++;
        }

        return ans == (int) 1e9 ? 0 : ans;
    }
}