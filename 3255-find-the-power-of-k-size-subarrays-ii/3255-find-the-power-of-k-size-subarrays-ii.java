class Solution {
    public int[] resultsArray(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(); 
        int n = nums.length;
        int ans[] = new int[n-k+1];

        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] != 1) 
                set.add(i-1);
        }

        int l = 0;
        int r = k-1;

        while(l <= n-k){
            Integer a = set.ceiling(l);

            if(a != null && a+1 <= r) {
                ans[l] = -1;
            }
            else {
                ans[l] = nums[r];
            }

            l++;
            r++;
        }

        return ans;
    }
}