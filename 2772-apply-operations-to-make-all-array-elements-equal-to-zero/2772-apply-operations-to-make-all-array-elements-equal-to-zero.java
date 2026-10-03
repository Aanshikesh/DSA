class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        // for(int i =0;i<=n-k;i++){
        //     if(nums[i]==0) continue;
        //     if(nums[i]<0) return false;
        //     int cur = nums[i];
        //     for(int j =i;j<i+k;j++){
        //         nums[j]-=cur;
        //     }
        // }
        // for(int i =n-k ;i<n;i++){
        //     if(nums[i]!=0) return false;

        // }
        // return true;

        int[] diff = new int[n+1];
        int pref = 0;

        for(int i = 0;i<nums.length;i++){
            //if(i+k>=n) break;
            pref += diff[i];

            int val = nums[i] - pref;

            if (val < 0) return false;

            if (val > 0) {
                if (i + k > n) return false;

                pref += val;
                diff[i + k] -= val;
            }
        }
        return true;

    }
}