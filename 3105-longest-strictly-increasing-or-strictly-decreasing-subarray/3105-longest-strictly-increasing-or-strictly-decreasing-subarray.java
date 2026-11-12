class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int ans =0;
        int count =1;
        for(int i=1 ;i<n;i++){
            if(nums[i-1]<nums[i]) count++;
            else count=1;
            ans = Math.max(ans,count);
        }
        count =1;
        for(int i=1 ;i<n;i++){
            if(nums[i-1]>nums[i]) count++;
            else count=1;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}