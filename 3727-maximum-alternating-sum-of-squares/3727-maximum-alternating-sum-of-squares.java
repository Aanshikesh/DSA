class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum1 =0;
        long sum2=0;
        for(int i =0;i<n;i++){
            if(i<n/2) sum1+= (long)nums[i]*nums[i];
            else sum2+= (long)nums[i]*nums[i];
        }

        return sum2-sum1;
    }
}