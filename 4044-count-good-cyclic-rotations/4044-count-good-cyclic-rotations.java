class Solution {
    public int countGoodRotations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        long left_sum = 0;
        long right_sum = 0;
        int middle = n/2;  // n-1 not included
        for(int i = 0 ; i < n/2 ; i++){
            left_sum+= nums[i];
        }
        for(int i = n/2 ; i < n ; i++){
            right_sum+= nums[i];
        }            
        // System.out.println("Value : "+left_sum+" = "+right_sum);
        if(left_sum != right_sum){
            ans++;
        }
        int index = 0;
        for(int i = middle ; i < n-1 ; i++){
            left_sum = left_sum - nums[index] + nums[i];
            right_sum = right_sum + nums[index++] - nums[i];
            // System.out.println("Value : "+left_sum+" = "+right_sum);
            if(left_sum != right_sum){
                ans++;
            }
        }
        return ans;
    }
}