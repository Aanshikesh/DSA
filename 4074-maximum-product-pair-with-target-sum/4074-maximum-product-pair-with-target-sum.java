class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1,-1};
        int max =Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i!=j && nums[i]+nums[j]==target && nums[i]>nums[j] && nums[i]*nums[j]>max ){
                    ans[0] =i;
                    ans[1] =j;
                    max = nums[i]*nums[j];
                }
            }
        }
        return ans;
    }
}