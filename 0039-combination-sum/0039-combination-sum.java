class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void solve(int[] candi, int target, List<Integer> dummy, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> list = new ArrayList(dummy);
            Collections.sort(list);
            if(ans.contains(list)) return;
            ans.add(list);
            return;
        }

        for (int i = 0; i < candi.length; i++) {
                dummy.add(candi[i]);
                solve(candi, target, dummy, sum + candi[i]);
                dummy.remove(dummy.size() - 1);
            
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> dummy = new ArrayList<>();
        solve(candidates, target, dummy, 0);

        return ans;
    }
}