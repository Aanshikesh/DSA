class Solution {
    List<List<Integer>>  ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        solve(0, nums, new ArrayList<>() , nums.length);
        return ans;
    }
    public void solve(int mask, int[] nums , List<Integer> list , int n){
        if(mask == (int)Math.pow(2,n)-1) {
            ans.add(new ArrayList<>(list));
            return ;
            }
        for(int i =0;i<n;i++){
           if((mask & (1<<i)) != 0) continue;
            list.add(nums[i]);
            solve((mask | (1<<i)), nums, list,n);
            list.remove(list.size()-1);
        }
    }
}