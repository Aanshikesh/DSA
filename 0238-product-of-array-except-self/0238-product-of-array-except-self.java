class Solution {
    public int[] productExceptSelf(int[] nums) {
        int a = nums.length;
        int [] l = new int[a];
        int [] r = new int[a];
        int [] ans = new int[a];
        l[0] = 1;
        for(int i = 1; i<a;i++){
            l[i] = nums[i-1]*l[i-1];
        }
        r[a-1] = 1;
        for(int i = a-2; i>=0;i--){
            r[i] = nums[i+1]*r[i+1];
        }
        for(int i = 0; i<a;i++){
            ans[i] = l[i]*r[i];
        }
        return ans;
    }
}