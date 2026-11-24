class Solution {
    public int maxLength(int[] nums) {
        int ans =0;
        for(int i = 0;i<nums.length;++i){
            long g  = nums[i] , l = nums[i] ,prod = nums[i];
            for(int j = i+1 ;j<nums.length; ++j){
                prod = prod *(long)nums[j];
                if(prod > 100000000000L) break;
                g = gcd(g , (long)nums[j]);
                l = lcm(l, (long)nums[j]);
                if(prod == g*l) {
                    ans= Math.max(ans , j-i+1);
                }
            }
        }
        return ans;
    }
    long gcd(long a,long b){
        return (b==0)?a : gcd(b, a%b);
    }
    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
}